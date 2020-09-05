import java.io.*;
import java.sql.*;

public class TestBank {
    public static void main(String[] args) throws ClassNotFoundException, SQLException,IOException {
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/bank?useSSL=false&characterEncoding=utf8";
        // 连接数据库的用户名
        String user = "root";
        // 连接数据库的密码
        String password = "";
        //链接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
        //获取文件路径
        String path = "F:\\银行实习课题\\banktest\\bank\\cha.sql";
        //读取.sql文件
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        //定义输出流
        FileWriter output = new FileWriter("F:\\银行实习课题\\banktest\\bank\\jieguo.txt");
        //定义SQL语句
        String sql;
        while ((sql = reader.readLine()) != null) {
            //  创建一个 Statement 语句
            Statement statement = connection.createStatement();
            //  执行
            if (sql.startsWith("select")) {
                ResultSet rs = statement.executeQuery(sql);
                int columnCount = rs.getMetaData().getColumnCount();
                System.out.println("sql:"+sql);
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        String result = rs.getString(i);
                        System.out.print(result + " ");
                        output.write(result+"\n");
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
