import java.io.*;
import java.sql.*;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException,IOException {
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/bank?useSSL=false&characterEncoding=utf8";
        // 连接数据库的用户名
        String user = "root";
        // 连接数据库的密码
        String password = "";
        String path = "F:\\sql.sql";
        Connection connection = DriverManager.getConnection(url, user, password);

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        FileWriter output = new FileWriter("F:\\结果.txt");
        String sql;
        while ((sql = reader.readLine()) != null) {
            // a) 创建一个 Statement 语句
            Statement statement = connection.createStatement();
            // b) 执行
            if (sql.startsWith("select")) {
                ResultSet rs = statement.executeQuery(sql);
                int columnCount = rs.getMetaData().getColumnCount();
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        String result = rs.getString(i);
                        System.out.print(result + " ");
                        output.write(result+"\n ");
                        output.flush();
                    }
                    System.out.println();
                }
                rs.close();
            }
            statement.close();
        }
        reader.close();
        output.close();

        // 4. 关闭连接
        connection.close();
    }
}
