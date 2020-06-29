import java.sql.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AccountDao {
    public boolean searchname(String name){
        boolean flag =false;
        Account account=new Account();
        Connection conn=BaseConnection.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql="select * from user where name=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1, name);
            rs=ps.executeQuery();
            if(rs.next()){
                flag=true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public boolean searchpassword(String password){
        boolean flag =false;
        Account account=new Account();
        Connection conn=BaseConnection.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql="select * from user where password=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1, password);
            rs=ps.executeQuery();
            //执行select语句
            if(rs.next()){
                flag=true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public  String showString(String name){
        String info=null;
        Connection conn = BaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql="select * from user where name=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            while(rs.next()){
                Account account=new Account();
                account.setUsername(rs.getString("name"));
                account.setPassword(rs.getString("password"));
                account.setMoney(rs.getDouble("money"));
                JOptionPane.showMessageDialog(null,
                        "您的账户名:"+account.getUsername()+"\n"+"当前余额:￥"+account.getMoney()+"\n","信息提示",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {


        }finally {
            BaseConnection.CloseRes(rs, ps, conn);
        }
        return info;
    }

    public double popMoney(String name){
        Connection conn = BaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        double usermoney=0.0;
        try {
            String sql = "select * from user where name=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while(rs.next()){
                Account account=new Account();
                account.setUsername(rs.getString("name"));
                account.setPassword(rs.getString("password"));
                account.setMoney(rs.getDouble("money"));
                account.setMoney(rs.getDouble("money"));
                usermoney=account.getMoney();
            }
        } catch (Exception e) {

        }finally {
            BaseConnection.CloseRes(rs, ps, conn);
        }
        return usermoney;
    }

    public boolean putMoney(Account account){
        boolean b=false;
        Connection conn = BaseConnection.getConnection();
        PreparedStatement ps = null;
        String sql = "update user set money=? where name=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, account.getMoney());
            ps.setString(2, account.getUsername());
            int a = ps.executeUpdate();
            //System.out.println(account.getMoney());
            if (a > 0) {
                b=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseConnection.CloseRes(ps, conn);
        }
        return b;
    }
    public boolean getMoney(Account account){
        boolean b=false;
        Connection conn = BaseConnection.getConnection();
        PreparedStatement ps = null;
        String sql = "update user set money=? where name=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, account.getMoney());
            ps.setString(2, account.getUsername());
            int a = ps.executeUpdate();
            //变化行数
            if (a > 0) {
                b=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseConnection.CloseRes(ps, conn);
        }
        return b;
    }

    public boolean putPassword(Account account){
        boolean b=false;
        Connection conn = BaseConnection.getConnection();
        PreparedStatement ps = null;
        String sql = "update user set password=? where name=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, account.getPassword());
            ps.setString(2, account.getUsername());
            int a = ps.executeUpdate();
            if (a > 0) {
                b=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseConnection.CloseRes(ps, conn);
        }
        return b;
    }


    public void insert(Account account){
        Connection conn=BaseConnection.getConnection();
        PreparedStatement ps=null;
        String sql="insert into user (name,password)"
                +"values('"+account.getUsername()+"','"+account.getPassword()+"')";
        System.out.println(sql);
        try {
            ps=conn.prepareStatement(sql);
            int a=ps.executeUpdate();
            if(a>0){
                JOptionPane.showMessageDialog(null, "注册成功！",
                        "信息提示",JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "注册失败！",
                        "信息提示",JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseConnection.CloseRes(ps, conn);
        }
    }

}