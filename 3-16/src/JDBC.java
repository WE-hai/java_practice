import java.sql.*;
import java.util.Scanner;

public class JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/stu?useSSL=false&characterEncoding=utf8";
        Connection connection = DriverManager.getConnection(url, "root", "");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String sql = scanner.nextLine();
            if (sql.trim().isEmpty()) {
                continue;
            }
            if (sql.equalsIgnoreCase("quit")) {
                break;
            }
            Statement statement = connection.createStatement();
            String firstWord = sql.split(" ")[0];
            if (firstWord.equalsIgnoreCase("select")
                    || firstWord.equalsIgnoreCase("show")
                    || firstWord.equalsIgnoreCase("desc")) {
                // 有结果的 SQL
                executeSQLWithResult(statement, sql);
            } else {
                // 没有结果的 SQL
                executeSQLWithoutResult(statement, sql);
            }
            statement.close();
        }
        // 4. 关闭连接
        connection.close();
    }

    private static void executeSQLWithoutResult(Statement statement, String sql) throws SQLException {
        int 受到影响的行数 = statement.executeUpdate(sql);
        System.out.println("受到影响的行数是: " +  受到影响的行数);
    }

    private static void executeSQLWithResult(Statement statement, String sql) throws SQLException {
        ResultSet rs = statement.executeQuery(sql);

        // 取到结果集元信息
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 0; i < columnCount; i++) {
            String columnName = metaData.getColumnName(i + 1);
            System.out.print(columnName + " ");
        }
        System.out.println();

        while (rs.next()) {
            for (int i = 0; i < columnCount; i++) {
                String value = rs.getString(i + 1);
                System.out.print(value + " ");
            }
            System.out.println();
        }

        rs.close();
    }
}
