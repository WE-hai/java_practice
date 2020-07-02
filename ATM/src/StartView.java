import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartView extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StartView frame = new StartView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StartView() {
        setResizable(false);
        setTitle("欢迎使用 ATM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 350);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLabel label = new JLabel("请选择您的操作:");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("隶书", Font.PLAIN, 18));
        label.setBackground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(100, 40, 150, 24);
        contentPane.add(label);

        JLayeredPane layeredPane = new JLayeredPane();
        contentPane.add(layeredPane, BorderLayout.CENTER);

        JButton btnNewButton = new JButton("注册");
        btnNewButton.setFont(new Font("黑体", Font.PLAIN, 16));
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBounds(125, 100, 80, 24);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /**
                 * 注册界面显示
                 */
                new Register().setVisible(true);

            }
        });
        layeredPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("登录");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /**
                 *登陆界面显示
                 */
                new LogOn().setVisible(true);

            }
        });
        btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 16));//设置字体
        btnNewButton_1.setForeground(Color.BLACK);
        btnNewButton_1.setBounds(125, 165, 80, 24);
        layeredPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("退出");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /**
                 * 菜单退出
                 */
                JOptionPane.showMessageDialog(null, "欢迎再次使用!!!","信息提醒",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
        btnNewButton_2.setFont(new Font("黑体", Font.PLAIN, 16));
        btnNewButton_2.setForeground(Color.BLACK);
        btnNewButton_2.setBounds(125, 230, 80, 24);
        layeredPane.add(btnNewButton_2);
    }

}

