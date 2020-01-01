import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.*;
 
public class StuAddDialog extends JDialog implements ActionListener{
	//=========���ؼ�
	//......��������
	private JLabel idLab,nameLab,sexLab,ageLab,jgLab,deptLab;
	//......�Ҳ���Ϣѡ����д��
	private JTextField idTxt,nameTxt,sexTxt,ageTxt,jgTxt,deptTxt;
	//......���Ӻ�ȡ����ť
	private JButton addBtn,cancelBtn;
	//......���ֿؼ�
	private JPanel left,center,bottom;
	
	//���캯��
	public StuAddDialog(Frame owner, String title, boolean modal) 
	{
		//========��д���෽��
		super(owner, title, modal);
		//========����ǩ��
		idLab = new JLabel("ѧ��: ");
		nameLab = new JLabel("����: ");
		sexLab = new JLabel("�Ա�: ");
		ageLab = new JLabel("����: ");
		jgLab = new JLabel("����: ");
		deptLab = new JLabel("ϵ��: ");
		//========�Ҳ���Ϣ��д��
		idTxt = new JTextField();
		nameTxt = new JTextField();
		sexTxt = new JTextField();
		ageTxt = new JTextField();
		jgTxt = new JTextField();
		deptTxt = new JTextField();
		//========���Ӻ�ȡ����ť
		addBtn = new JButton("����");
		cancelBtn = new JButton("ȡ��");
		//......���Ӽ���
		addBtn.addActionListener(this);
		addBtn.setActionCommand("add");
		cancelBtn.addActionListener(this);
		cancelBtn.setActionCommand("cancel");
		//========��������
		//......���������
		left = new JPanel();
		left.setLayout(new GridLayout(6, 1));
		left.add(idLab);  left.add(nameLab); 
		left.add(sexLab); left.add(ageLab); 
		left.add(jgLab);  left.add(deptLab); 
		//......�����ұ���
		center = new JPanel();
		center.setLayout(new GridLayout(6, 1));
		center.add(idTxt);  center.add(nameTxt);
		center.add(sexTxt); center.add(ageTxt);
		center.add(jgTxt);  center.add(deptTxt);
		//========�ײ����Ӻ�ȡ����ť
		bottom = new JPanel();
		bottom.add(addBtn);
		bottom.add(cancelBtn);
		//========���岼��
		this.add(left,BorderLayout.WEST);
		this.add(center,BorderLayout.CENTER);
		this.add(bottom,BorderLayout.SOUTH);
		//========���ô�������
		
		this.setSize(300, 250);
		this.setResizable(false);
		this.setVisible(true);
	}
 

	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("add")) {
			/***********************����ѧ����Ϣ**************************/
			StuModel tmp = new StuModel();
			String sql = "insert into stu values(?,?,?,?,?,?)";
			String []paras = {idTxt.getText(),nameTxt.getText(),sexTxt.getText(),
							ageTxt.getText(),jgTxt.getText(),deptTxt.getText()};
			if(!tmp.cudStu(sql, paras))
				JOptionPane.showMessageDialog(this, "����ѧ����Ϣʧ��");
			//========�رմ���
			this.dispose();
		} else if(e.getActionCommand().equals("cancel")) {
			//========�رմ���
			this.dispose();
		}
	}
}