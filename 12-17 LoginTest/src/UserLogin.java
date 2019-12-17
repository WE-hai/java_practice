
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UserLogin extends JFrame implements ActionListener {
	JLabel jl1, jl2, jl3;
	JTextField jtf, jtfMm;
	JButton jbtOk, jbtEsc;

	public UserLogin() {
		// 设置窗体的属性
		this.setTitle("登陆");
		this.setSize(295, 340);
		this.setLocation(400, 180);
		// 获取窗体的内容面板
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));
		// cp.setLayout(null);
		// 创建组件

		jl2 = new JLabel("欢迎使用本系统！", JLabel.CENTER);
		jl2.setFont(new Font("黑体", Font.BOLD, 24));
		jl2.setForeground(Color.BLUE);

		jl1 = new JLabel("用户名：", JLabel.RIGHT);
		jl3 = new JLabel("密   码：", JLabel.RIGHT);
		jtf = new JTextField(15);
		jtfMm = new JTextField(15);
		jbtOk = new JButton("登陆");
		jbtEsc = new JButton("注册");

		// 添加组件
		cp.add(jl2);
		cp.add(jl1);
		cp.add(jtf);
		cp.add(jl3);
		cp.add(jtfMm);
		cp.add(jbtOk);
		cp.add(jbtEsc);

		// 注册监听
		jbtOk.addActionListener(this);
		jbtEsc.addActionListener(this);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		UserLogin uf = new UserLogin();

	}

	public void actionPerformed(ActionEvent e) {
		
		String name = jtf.getText().trim();
		String passW = jtfMm.getText().trim();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String ur1 = "jdbc:sqlserver://localhost:1433;DatabaseName=user";
		
		//String driver = "com.mysql.jdbc.Driver";
		//String url = "jdbc:mysql://127.0.0.1:3306/user";
		
		try {
			// 1、加载驱动
			Class.forName(driver);
			
			// 2、创建连接
			con = DriverManager.getConnection(ur1,"sa","123456");
			stmt = con.createStatement();
			
			//con = DriverManager.getConnection(url,"root","");
			//stmt = con.createStatement();
			
			rs = stmt.executeQuery("select * from uer");
			while(rs.next()) {
				System.out.println(rs.getInt("uid")+" "+rs.getString("uname"));
			}
			/*
			// 3、创建Statement
			if (e.getActionCommand().equals("注册")) {// 4、发送sql语句
				this.setTitle("点击了注册按钮");
				
					int n=stmt.executeUpdate("INSERT INTO user1 VALUES('"	+ name + "','"+ passW + "')");
					// 5、对结果集进行处理
					
					if (n==1) {
						JOptionPane.showMessageDialog(this, "信息注册成功！");
					} else
						JOptionPane.showMessageDialog(this, "注册失败！");
					
					// 关闭连接
					rs.close();
					stmt.close();
					con.close();
			}
			*/
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception err) {
			err.printStackTrace();
			
		}

		
		 

		}
	}


