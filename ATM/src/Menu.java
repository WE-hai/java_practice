import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {


    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu(null,null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Menu(final String name, String password) {
        setResizable(false);

        setTitle("用户菜单界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 266);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setForeground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setForeground(Color.BLACK);
        layeredPane.setBackground(Color.BLACK);
        contentPane.add(layeredPane, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("账户姓名："+name);
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(115, 35, 183, 15);
        layeredPane.add(lblNewLabel);

        JLabel lblatm = new JLabel("欢迎使用");
        lblatm.setForeground(Color.BLUE);
        lblatm.setFont(new Font("华文行楷", Font.PLAIN, 16));
        lblatm.setHorizontalAlignment(SwingConstants.LEFT);
        lblatm.setBounds(175, 15, 183, 15);
        layeredPane.add(lblatm);

        JButton Searchaccount = new JButton("查询");
        Searchaccount.setForeground(Color.black);
        Searchaccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /**
                 * 用户查询功能
                 */
                AccountDao ad=new AccountDao();
                ad.showString(name);


            }
        });
        Searchaccount.setBounds(52, 70, 93, 23);
        layeredPane.add(Searchaccount);

        JButton PopMoney = new JButton("取款");
        PopMoney.setForeground(Color.black);
        PopMoney.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new GetMoney(name, password).setVisible(true);
                dispose();
            }
        });
        PopMoney.setBounds(253, 70, 93, 23);
        layeredPane.add(PopMoney);

        JButton PutMoney = new JButton("存款");
        PutMoney.setForeground(Color.black);
        PutMoney.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 用户存款功能
                Account account=new Account();
                AccountDao ad=new AccountDao();
                String  s= JOptionPane.showInputDialog("请输入存款金额:");
                double money=Double.parseDouble((s.equals("")?"0":s));
                if(money<=0){
                    JOptionPane.showMessageDialog(null, "输入金额错误！",
                            "信息提示",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    double tempMoney=ad.popMoney(name);
                    double finalMoney=tempMoney+money;
                    account.setMoney(finalMoney);
                    account.setUsername(name);
                    ad.putMoney(account);
                    JOptionPane.showMessageDialog(null, "存款成功，当前余额:￥"+finalMoney,
                            "信息提示",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        PutMoney.setBounds(52, 120, 93, 23);
        layeredPane.add(PutMoney);




        JButton button = new JButton("转账");
        button.setForeground(Color.black);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 用户转账
                Account account=new Account();
                Account account2=new Account();
                AccountDao ad=new AccountDao();
                AccountDao ad2=new AccountDao();
                String userName2=JOptionPane.showInputDialog("请输入你要转入的账户名");
                if(userName2.equals(name)){
                    JOptionPane.showMessageDialog(null, "用户不能给自己转账的哦!!!", "哈哈",
                            JOptionPane.ERROR_MESSAGE);
                }else if(ad.searchname(userName2)!=true){
                    JOptionPane.showMessageDialog(null, "用户不存在，请核证后再转账!", "信息提示",
                            JOptionPane.ERROR_MESSAGE);
                }
                else {
                    double tempMoney2=ad2.popMoney(userName2);
                    double tempMoney=ad.popMoney(name);
                    String  s= JOptionPane.showInputDialog("请输转账金额:");
                    double money=Double.parseDouble((s.equals("")?"0":s));

                    if(tempMoney<money){
                        JOptionPane.showMessageDialog(null, "您的余额不足!", "信息提示",
                                JOptionPane.ERROR_MESSAGE);
                    }else if (money==0) {
                        JOptionPane.showMessageDialog(null, "输入金额错误!", "信息提示",
                                JOptionPane.ERROR_MESSAGE);
                    }else {
                        double finalMoney2=tempMoney2+money;
                        double finalMoney=tempMoney-money;
                        account2.setMoney(finalMoney2);
                        account2.setUsername(userName2);
                        ad2.putMoney(account2);
                        account.setMoney(finalMoney);
                        account.setUsername(name);
                        ad.putMoney(account);
                        JOptionPane.showMessageDialog(null, "转账成功！","信息提示",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        button.setBounds(253, 120, 93, 23);
        layeredPane.add(button);

        JButton changePassWord = new JButton("改密");
        changePassWord.setForeground(Color.black);
        changePassWord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Account account=new Account();
                AccountDao ad=new AccountDao();
                String  newPassWord= JOptionPane.showInputDialog("请输入新的密码:");
                if(newPassWord.equals(password)){
                    JOptionPane.showMessageDialog(null, "与原密码相同，改密不成功", "信息提示",
                            JOptionPane.ERROR_MESSAGE);
                }else {
                    String  newPassWord1= JOptionPane.showInputDialog("请再次确认密码:");
                    if(!newPassWord1.equals(newPassWord)) {
                        JOptionPane.showMessageDialog(null, "两次密码不相同请再次确认", "信息提示",
                                JOptionPane.ERROR_MESSAGE);
                    }else {
                        account.setPassword(newPassWord1);
                        account.setUsername(name);
                        ad.putPassword(account);
                        JOptionPane.showMessageDialog(null, "改密成功！","信息提示",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }

        });
        changePassWord.setBounds(52, 170, 93, 23);
        layeredPane.add(changePassWord);





        JButton Exit = new JButton("退出");
        Exit.setForeground(Color.gray);
        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "欢迎再次登陆使用！！！","信息提示",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();

            }
        });
        Exit.setBounds(253, 170, 93, 23);
        layeredPane.add(Exit);

    }
}
