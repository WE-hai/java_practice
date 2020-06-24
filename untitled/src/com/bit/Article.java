package com.bit;

import javax.servlet.ServletException;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Article {
    int id;
    User author;
    String title;
    Image image;
    String body;

    public Article(int id, User author, String title, Image image, String body) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.image = image;
        this.body = body;
    }

    public static Article publish(User author, String title, Image image, String body) throws ServletException {
        try (Connection con = DB.getConnection()) {
            String sql = "INSERT INTO articles (author_id, image_id, title, body) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, author.id);
                stmt.setInt(2, image.id);
                stmt.setString(3, title);
                stmt.setString(4, body);

                stmt.executeUpdate();
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        return new Article(id, author, title, image, body);
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

    public static Article getById(int id) throws ServletException {
        try (Connection con = DB.getConnection()) {
            String sql = "SELECT title, author_id, users.username author_username, image_id, body FROM articles, users WHERE articles.author_id = users.id AND articles.id = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String title = rs.getString("title");
                        int authorId = rs.getInt("author_id");
                        String authorUsername = rs.getString("author_username");
                        int imageId = rs.getInt("image_id");
                        String body = rs.getString("body");

                        User author = new User(authorId, authorUsername);
                        Image image = new Image(imageId);
                        return new Article(id, author, title, image, body);
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

    public static List<Article> list() throws ServletException {
        List<Article> articleList = new ArrayList<>();

        try (Connection con = DB.getConnection()) {
            String sql = "SELECT " +
                    "articles.id article_id, " +
                    "users.id author_id, " +
                    "users.username author_username, " +
                    "image_id, " +
                    "title, " +
                    "body " +
                    "FROM articles, users " +
                    "WHERE articles.author_id = users.id " +
                    "ORDER BY articles.id DESC";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        int articleId = rs.getInt("article_id");
                        int authorId = rs.getInt("author_id");
                        String authorUsername = rs.getString("author_username");
                        int imageId = rs.getInt("image_id");
                        String title = rs.getString("title");
                        String body = rs.getString("body");

                        User author = new User(authorId, authorUsername);
                        Image image = new Image(imageId);

                        Article article = new Article(articleId, author, title, image, body);
                        articleList.add(article);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

        return articleList;
    }
}
