import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.*;


public class GetMoney extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GetMoney frame = new GetMoney(null, null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GetMoney(final String name,final String password) {
        setResizable(false);
        setTitle("取款界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 402, 245);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLayeredPane layeredPane = new JLayeredPane();
        contentPane.add(layeredPane, BorderLayout.CENTER);

        JButton button = new JButton("100");
        button.setForeground(Color.BLUE);
        button.addActionListener(new ActionListener() {
                                     public void actionPerformed(ActionEvent e) {
                                         Account account=new Account();
                                         AccountDao ad=new AccountDao();
                                         double tempmoney=ad.popMoney(name);
                                         if(tempmoney<100){
                                             JOptionPane.showMessageDialog(null, "对不起，您的余额不够！",
                                                     "信息提示",JOptionPane.ERROR_MESSAGE);
                                         }else {
                                             double finalMoney=tempmoney-100;
                                             account.setMoney(finalMoney);
                                             account.setUsername(name);
                                             ad.putMoney(account);
                                             JOptionPane.showMessageDialog(null, "取款成功，当前余额:￥"+finalMoney,
                                                     "信息提示",JOptionPane.INFORMATION_MESSAGE);
                                         }
                                     }


                                 }

        );
        button.setBounds(40, 53, 93, 23);
        layeredPane.add(button);

        JButton button_1 = new JButton("200");
        button_1.setForeground(Color.BLUE);
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Account account=new Account();
                AccountDao ad=new AccountDao();
                double tempmoney=ad.popMoney(name);
                if(tempmoney<200){
                    JOptionPane.showMessageDialog(null, "对不起，您的余额不够！",
                            "信息提示",JOptionPane.ERROR_MESSAGE);
                }else {
                    double finalMoney=tempmoney-200;
                    account.setMoney(finalMoney);
                    account.setUsername(name);
                    ad.putMoney(account);
                    JOptionPane.showMessageDialog(null, "取款成功，当前余额:￥"+finalMoney,
                            "信息提示",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        button_1.setBounds(40, 98, 93, 23);
        layeredPane.add(button_1);

        JButton button_2 = new JButton("500");
        button_2.setForeground(Color.BLUE);
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Account account=new Account();
                AccountDao ad=new AccountDao();
                double tempmoney=ad.popMoney(name);
                if(tempmoney<500){
                    JOptionPane.showMessageDialog(null, "对不起，您的余额不够！",
                            "信息提示",JOptionPane.ERROR_MESSAGE);
                }else {
                    double finalMoney=tempmoney-500;
                    account.setMoney(finalMoney);
                    account.setUsername(name);
                    ad.putMoney(account);
                    JOptionPane.showMessageDialog(null, "取款成功，当前余额:￥"+finalMoney,
                            "信息提示",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        button_2.setBounds(40, 139, 93, 23);
        layeredPane.add(button_2);

        JButton button_3 = new JButton("1000");
        button_3.setForeground(Color.BLUE);
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Account account=new Account();
                AccountDao ad=new AccountDao();
                double tempmoney=ad.popMoney(name);
                if(tempmoney<1000){
                    JOptionPane.showMessageDialog(null, "对不起，您的余额不够！",
                            "信息提示",JOptionPane.ERROR_MESSAGE);
                }else {
                    double finalMoney=tempmoney-1000;
                    account.setMoney(finalMoney);
                    account.setUsername(name);
                    ad.putMoney(account);
                    JOptionPane.showMessageDialog(null, "取款成功，当前余额:￥"+finalMoney,
                            "信息提示",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        button_3.setBounds(195, 53, 93, 23);
        layeredPane.add(button_3);

        JButton button_4 = new JButton("手动输入");
        button_4.setForeground(Color.BLUE);
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //手动输入取款金额
                String  s= JOptionPane.showInputDialog("请输入取款金额:");
                double money=Double.parseDouble((s.equals("")?"0":s));
                Account account=new Account();
                AccountDao ad=new AccountDao();
                double tempmoney=ad.popMoney(name);
                if(money<=0){
                    JOptionPane.showMessageDialog(null, "输入金额错误！",
                            "信息提示",JOptionPane.ERROR_MESSAGE);
                }else if(tempmoney<money){
                    JOptionPane.showMessageDialog(null, "对不起，您的余额不够！",
                            "信息提示",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    tempmoney=ad.popMoney(name);
                    double finalMoney=tempmoney-money;
                    account.setMoney(finalMoney);
                    account.setUsername(name);
                    ad.putMoney(account);
                    JOptionPane.showMessageDialog(null, "取款成功，当前余额:￥"+finalMoney,
                            "信息提示",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        button_4.setBounds(195, 139, 93, 23);
        layeredPane.add(button_4);

        JButton button_5 = new JButton("2000");
        button_5.setForeground(Color.BLUE);
        button_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Account account=new Account();
                AccountDao ad=new AccountDao();
                double tempmoney=ad.popMoney(name);
                if(tempmoney<2000){
                    JOptionPane.showMessageDialog(null, "对不起，您的余额不够！",
                            "信息提示",JOptionPane.ERROR_MESSAGE);
                }else {
                    double finalMoney=tempmoney-2000;
                    account.setMoney(finalMoney);
                    account.setUsername(name);
                    ad.putMoney(account);
                    JOptionPane.showMessageDialog(null, "取款成功，当前余额:￥"+finalMoney,
                            "信息提示",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        button_5.setBounds(195, 98, 93, 23);
        layeredPane.add(button_5);

        JLabel label = new JLabel("账户姓名:"+name);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        label.setBounds(69, 10, 183, 15);
        layeredPane.add(label);

        JButton button_6 = new JButton("返回");
        button_6.setForeground(Color.BLUE);
        button_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu(name, password).setVisible(true);
            }
        });
        button_6.setBounds(290, 172, 60, 23);
        layeredPane.add(button_6);
    }
}
