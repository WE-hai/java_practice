package com;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

//继承JFrame类，建立图形界面
public class View extends JFrame {

	private static final long serialVersionUID = -1230964640662884509L;
	private Matrix matrix = Matrix.getInstance();
	//设置标题，得分，最佳记录标签和退出，开始按钮
	private JLabel[][] labels = new JLabel[Constant.SIZE][Constant.SIZE];
	private JLabel headLabel = new JLabel("2 0 4 8", JLabel.CENTER);
	private JLabel scoreLabel = new JLabel("score " + matrix.getScore(), JLabel.CENTER);
	private JLabel bestLabel = new JLabel("best " + matrix.getBest(), JLabel.CENTER);
	private JButton saveBtn = new JButton("Exit");
	private JButton reStartBtn = new JButton("start");
	//对操作界面的位置，大小进行设置
	public View() {
		setVisible(true);
		setBounds(650, 250, 500, 700);   //setBounds（int x, int y, int width, int height） （左上角横坐标，纵坐标，宽度，长度）
		setLayout(null);

		saveBtn.setBounds(250, 100, 70, 40);
		saveBtn.setFocusable(false);
		add(saveBtn);

		reStartBtn.setBounds(350, 100, 70, 40);
		reStartBtn.setFocusable(false);
		add(reStartBtn);

		headLabel.setBounds(20, 12, 200, 100);
		headLabel.setFont(new java.awt.Font("Dialog", 1, 60));
		headLabel.setForeground(new Color(119, 110, 101));
		add(headLabel);

		scoreLabel.setBounds(250, 20, 100, 50);
		scoreLabel.setOpaque(true);
		scoreLabel.setFont(new java.awt.Font("Dialog", 1, 15));
		scoreLabel.setBackground(new Color(187, 173, 160));
		add(scoreLabel);

		bestLabel.setBounds(350, 20, 100, 50);
		bestLabel.setOpaque(true);
		bestLabel.setFont(new java.awt.Font("Dialog", 1, 15));
		bestLabel.setBackground(new Color(187, 173, 160));
		add(bestLabel);

		// 用于拼图布局之间的间隔
		int baseX = 15;
		int baseY = 170;
		for (int i = 0; i < labels.length; i++) {
			for (int j = 0; j < labels.length; j++) {
				labels[i][j] = new JLabel("0", JLabel.CENTER);
				labels[i][j].setOpaque(true);
				labels[i][j].setBounds(baseX, baseY, 100, 100);
				labels[i][j].setBackground(ColorMap.colorMap.get(0).backGroundColor);
				labels[i][j].setForeground(ColorMap.colorMap.get(0).textColor);
				labels[i][j].setFont(new java.awt.Font("Dialog", 1, 40));
				add(labels[i][j]);
				baseX += 120;
			}
			baseY += 120;
			baseX = 15;
		}

		matrix.initMatrix();
		reColor();

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						matrix.left();
						break;
					case KeyEvent.VK_RIGHT:
						matrix.right();
						break;
					case KeyEvent.VK_UP:
						matrix.up();
						break;
					case KeyEvent.VK_DOWN:
						matrix.down();
						break;
				}
				reColor();
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		//设置退出按钮，退出程序并保存数据
		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				matrix.save();
				JOptionPane.showMessageDialog(View.this, "保存成功！");
				System.exit(0);
			}
		});
		//设置开始按钮，初始化界面
		reStartBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				matrix.reStart();
				reColor();
			}
		});
	}
	//设置操作界面的颜色，调用ColorMap中的函数
	private void reColor() {
		int value = 0;
		for (int i = 0; i < labels.length; i++) {
			for (int j = 0; j < labels.length; j++) {
				value = matrix.matrix[i][j];
				labels[i][j].setBackground(ColorMap.colorMap.get(value).backGroundColor);
				labels[i][j].setText(value + "");
				labels[i][j].setForeground(ColorMap.colorMap.get(value).textColor);
			}

		}
		scoreLabel.setText("score " + matrix.getScore() + "");
		// 刷新最高分
		if (matrix.getScore() > matrix.getBest()) {
			matrix.setBest(matrix.getScore());
		}
		bestLabel.setText("best " + matrix.getBest() + "");
	}

	public static void main(String[] args) {
		new View();
	}
}
