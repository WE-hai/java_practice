import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Register extends JFrame {

    private JPanel contentPane;
    private JTextField NewName;
    private JPasswordField NewPassword;
    private JPasswordField RnewPassword;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register frame = new Register();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Register() {

        setResizable(false);
        setTitle("用户注册");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 367, 225);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLabel label = new JLabel("新用户注册");
        label.setForeground(Color.black);
        label.setFont(new Font("华文隶书", Font.PLAIN, 16));
        label.setBackground(new Color(0, 255, 51));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label, BorderLayout.NORTH);

        JLayeredPane layeredPane = new JLayeredPane();
        contentPane.add(layeredPane, BorderLayout.CENTER);

        JLabel label_1 = new JLabel("用户名:");
        label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        label_1.setForeground(Color.BLACK);
        label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_1.setBounds(33, 25, 54, 15);
        layeredPane.add(label_1);

        JLabel label_2 = new JLabel("密码:");
        label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        label_2.setForeground(Color.BLACK);
        label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        label_2.setBounds(33, 59, 54, 15);
        layeredPane.add(label_2);

        JLabel label_3 = new JLabel("确认密码:");
        label_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        label_3.setForeground(Color.BLACK);
        label_3.setHorizontalAlignment(SwingConstants.RIGHT);
        label_3.setBounds(21, 94, 66, 15);
        layeredPane.add(label_3);

        NewName = new JTextField();
        NewName.setBounds(127, 23, 95, 21);
        layeredPane.add(NewName);
        NewName.setColumns(10);

        NewPassword = new JPasswordField();
        NewPassword.setBounds(127, 57, 95, 21);
        layeredPane.add(NewPassword);

        RnewPassword = new JPasswordField();
        RnewPassword.setBounds(127, 92, 95, 21);
        layeredPane.add(RnewPassword);

        JButton zhuce = new JButton("注册");
        zhuce.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String NuserName=NewName.getText();
                String Nuserpassword=NewPassword.getText();
                String RuserPassword=RnewPassword.getText();
                if(RuserPassword.length()!=6){
                    JOptionPane.showMessageDialog(null, "密码必须为6位数！", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
                    new Register().setVisible(true);
                    dispose();
                }else if (Nuserpassword.equals(RuserPassword)) {
                    //  向数据库新加入用户；
                    Account account=new Account();
                    AccountDao ad=new AccountDao();
                    account.setUsername(NuserName);
                    account.setPassword(Nuserpassword);
                    ad.insert(account);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "两次密码输入不一致！", "温馨提示", JOptionPane.ERROR_MESSAGE);
                    new Register().setVisible(true);
                    dispose();
                }
            }
        });
        zhuce.setForeground(Color.black);
        zhuce.setFont(new Font("黑体", Font.PLAIN, 22));
        zhuce.setBounds(230, 130, 85, 26);
        layeredPane.add(zhuce);
    }
}