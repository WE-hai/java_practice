import java.io.*;
import java.sql.*;

/**
 * 读取指定文件下sql脚本，执行到数据库
 * 逐行读取分批处理批量插入数据库
 */
public class Test {
    public static void main(String[] args) {
        System.err.println("begin");
        long start = System.currentTimeMillis();
        String path = "F:\\课程文档\\java\\java\\banktest\\sql.sql";
        getData(path);
        System.err.print((System.currentTimeMillis() - start) / 1000);

    }

    private static void getData(String path) {
        //读取文件
        BufferedReader reader;
        Connection con = null;
        Statement pst = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/atm?useSSL=false&characterEncoding=utf-8", "root", "");
            pst = con.createStatement();
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                pst.addBatch(line);
                System.out.println("-----------------------");
                System.out.println(line);
                System.out.println("-----------------------");
                if (i % 100 == 0) {
                    System.out.println("执行了：" + i);
                    pst.executeBatch();
                }
                i += 1;
            }
            reader.close();
            // 执行批量更新
            pst.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

