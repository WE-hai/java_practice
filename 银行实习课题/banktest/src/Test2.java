import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException,IOException {
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/bankdata?useSSL=false&characterEncoding=utf8";
        // 连接数据库的用户名
        String user = "root";
        // 连接数据库的密码
        String password = "";
        //链接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
        //获取文件路径
		/*
        String path = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入1 2 3 4 5 6（1 表示只有存款，2表示只有信贷，3表示只有理财，4表示存款与理财，5表示有存款与信贷，6表示理财与信贷）：");
        int n = scanner.nextInt();
        switch (n) {
            case 1:
                path = "F:\\银行实习课题\\banktest\\sql\\c.sql";
                break;
            case 2:
                path = "F:\\银行实习课题\\banktest\\sql\\d.sql";
                break;
            case 3:
                path = "F:\\银行实习课题\\banktest\\sql\\l.sql";
                break;
			case 4:
				path = "F:\\银行实习课题\\banktest\\sql\\cl.sql";
                break;
			case 5:
				path = "F:\\银行实习课题\\banktest\\sql\\cd.sql";
                break;
			case 6:
				path = "F:\\银行实习课题\\banktest\\sql\\ld.sql";
                break;
            default:
                System.out.print("输入错误！");
        }
		*/
        //读取.sql文件
        //BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        //定义输出流
        //FileWriter output = new FileWriter("F:\\银行实习课题\\banktest\\result\\结果.txt");
        //定义SQL语句
        String sql = "select count(*) from user,cun where user.age = '21-25岁' and user.cunkuan != '1万元以下' and  user.id = cun.id";
        //while ((sql = reader.readLine()) != null) {
            //  创建一个 Statement 语句
            Statement statement = connection.createStatement();
            //  执行
            if (sql.startsWith("")) {
                ResultSet rs = statement.executeQuery(sql);
                int columnCount = rs.getMetaData().getColumnCount();
                System.out.println("sql:"+sql);
                while (rs.next()) {
                    //System.out.println(sql);
                    for (int i = 1; i <= columnCount; i++) {
                        String result = rs.getString(i);
                        System.out.print(result + " ");
                        //output.write(result+"\n");
                        //output.flush();
                    }
                    System.out.println();
                }
                rs.close();
            }
            statement.close();
        //}
        //reader.close();
        //output.close();

        // 4. 关闭连接
        connection.close();
    }
}
