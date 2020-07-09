package maths;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class UserLogin extends JFrame implements ActionListener {
	JLabel jl1, jl2, jl3;
	JTextField jtf, jtfMm;
	JButton jbtOk, jbtEsc;

	public UserLogin() {
		// 设置窗体的属性
		this.setTitle("四则运算系统");
		this.setSize(340, 340);
		this.setLocation(500, 200);
		// 获取窗体的内容面板
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));
		// 创建组件
		jl2 = new JLabel("欢迎使用四则运算系统", JLabel.CENTER);
		jl2.setFont(new Font("宋体", Font.BOLD, 24));
		jl2.setForeground(Color.RED);
		jl1 = new JLabel("用户名：", JLabel.CENTER);
		jl1.setFont(new Font("宋体", Font.BOLD,16));
		jl3 = new JLabel("密  码：", JLabel.CENTER);
		jl3.setFont(new Font("宋体", Font.BOLD,16));
		jtf = new JTextField(15);
		jtf.setFont(new Font("宋体", Font.BOLD,16));
		jtfMm = new JPasswordField(15);
		jtfMm.setFont(new Font("宋体", Font.BOLD,16));
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
		//数据库连接
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/user";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"root","");
			stmt = con.createStatement();
			if (e.getActionCommand().equals("注册")) {
				this.setTitle("点击了注册按钮");
				int n=stmt.executeUpdate("INSERT INTO user VALUES('"	+ name + "','"+ passW + "')");
				if (n==1) {
					JOptionPane.showMessageDialog(this, "信息注册成功！");
				} else
					JOptionPane.showMessageDialog(this, "注册失败！");
			} else if(e.getActionCommand().equals("登陆")) {
				this.setTitle("点击了登陆按钮");
				rs = stmt.executeQuery("select passW from user where uname = '"+name+"'");
				if(rs.next()) {
					if(rs.getString("passW").equals(passW)) {
						new MyExGUI();
					} else {
						JOptionPane.showMessageDialog(this,"密码错误！");
					}
				} else {
					JOptionPane.showMessageDialog(this,"用户名错误！");
				}
			}

		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}