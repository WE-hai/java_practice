import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LogOn extends JFrame {
    private JPanel contentPane;
    private JTextField UserId;
    private JPasswordField UserPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LogOn frame = new LogOn();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public LogOn() {
        setResizable(false);
        setTitle("用户登录界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 316, 235);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLayeredPane layeredPane = new JLayeredPane();
        contentPane.add(layeredPane, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("欢迎使用");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("方正舒体", Font.PLAIN, 16));
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setBounds(83, 10, 111, 15);
        layeredPane.add(lblNewLabel);

        JLabel User = new JLabel("用户名:");
        User.setHorizontalAlignment(SwingConstants.RIGHT);
        User.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        User.setForeground(Color.BLACK);
        User.setBounds(24, 44, 60, 15);
        layeredPane.add(User);

        JLabel PassWord = new JLabel("密码:");
        PassWord.setHorizontalAlignment(SwingConstants.RIGHT);
        PassWord.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        PassWord.setForeground(Color.BLACK);
        PassWord.setBounds(24, 106, 60, 15);
        layeredPane.add(PassWord);

        UserId = new JTextField();
        UserId.setBounds(103, 42, 93, 21);
        layeredPane.add(UserId);
        UserId.setColumns(10);

        UserPassword = new JPasswordField();
        UserPassword.setBounds(103, 104, 93, 21);
        layeredPane.add(UserPassword);

        JButton jb_logon = new JButton("登录");
        jb_logon.addActionListener(new ActionListener() {
                                       public void actionPerformed(ActionEvent e) {
                                           //登陆的验证，用户登陆
                                           String userId=UserId.getText();
                                           String userPassword=UserPassword.getText();
                                           AccountDao ad=new AccountDao();
                                           boolean fixusername=ad.searchname(userId);
                                           boolean fixuserpass=ad.searchpassword(userPassword);
                                           if(fixusername&&fixuserpass){
                                               //登陆成功
                                               JOptionPane.showMessageDialog(null, "登陆成功",
                                                       "信息提示",JOptionPane.INFORMATION_MESSAGE);
                                               new Menu(userId, userPassword).setVisible(true);
                                               dispose();
                                           }else {
                                               JOptionPane.showMessageDialog(null, "登陆失败，用户名或密码错误！",
                                                       "信息提示",JOptionPane.ERROR_MESSAGE);

                                           }

                                       }
                                   }
        );
        jb_logon.setFont(new Font("黑体", Font.PLAIN, 20));
        jb_logon.setForeground(Color.BLACK);
        jb_logon.setBounds(103, 150, 93, 30);
        layeredPane.add(jb_logon);

    }
}