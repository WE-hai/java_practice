package com.bit;

import javax.servlet.ServletException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class User {
    int id;
    String username;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }


    public static User insert(String username, String password) throws ServletException {
        // 1. 永远不用在数据库中保存用户的明文密码
        // 1. 首先把 password 进行 hash 处理（这里使用 sha256 算法)
        password = encrypted(password);

        // 2. 利用 JDBC 保存 MySQL
        try (Connection connection = DB.getConnection()) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, username);
                stmt.setString(2, password);

                stmt.executeUpdate();
                // 插入成功

                // 3. id 是自增主键，所以，利用 JDBC 的方法取出 id
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt(1);

                        // 4. 返回构建好的用户对象
                        return new User(id, username);
                    }
                }
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        // 如果插入过程中，出现问题，返回 null
        return null;
    }

    // 利用 SHA-256 算法，给密码做 hash 处理
    public static String encrypted(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] input = password.getBytes("UTF-8");
            byte[] output = messageDigest.digest(input);

            StringBuilder sb = new StringBuilder();
            for (byte b : output) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return password;
        }
    }

    public static User getByUsernameAndPassword(String username, String password) throws ServletException {
        // 1. 先把明文密码 SHA-256 计算
        password = encrypted(password);

        // 2. 通过 JDBC,进行查询
        try (Connection con = DB.getConnection()) {
            String sql = "SELECT id FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int id = rs.getInt("id");
                        return new User(id, username);
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
