package com;

import java.io.*;
import java.util.*;

public class Matrix {
	//游戏初始化
	private int score = 0;
	private int best = 0;
	public int[][] matrix = new int[Constant.SIZE][Constant.SIZE];
	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
	//定义上下左右的移动
	public void left() {
		int[][] temp = deepArrayCopy();
		leftMerge();
		leftMove();
		// 并不能移动或者合并，相当于无效操作，不产生新值
		if (!Arrays.deepEquals(temp, matrix)) {
			generate();
		}
	}
	public void up() {
		int[][] temp = deepArrayCopy();
		upMerge();
		upMove();
		if (!Arrays.deepEquals(temp, matrix)) {
			generate();
		}
	}
	public void right() {
		int[][] temp = deepArrayCopy();
		rightMerge();
		rightMove();
		if (!Arrays.deepEquals(temp, matrix)) {
			generate();
		}
	}
	public void down() {
		int[][] temp = deepArrayCopy();
		downMerge();
		downMove();
		if (!Arrays.deepEquals(temp, matrix)) {
			generate();
		}
	}


	private int[][] deepArrayCopy() {
		int[][] temp = new int[Constant.SIZE][Constant.SIZE];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				temp[i][j] = matrix[i][j];
			}
		}
		return temp;
	}

	//getInstance保证了每次调用都返回相同的对象
	public static Matrix getInstance() {
		return new Matrix();
	}

	private static final int SIZE = 4;

	public static void main(String[] args) {
		Matrix t = new Matrix();
		t.initMatrix();
		t.left();
		t.showMatrix();
		t.save();
		System.out.println(t.getScore());
	}

	public int getBest() {
		return best;
	}

	public void setBest(int best) {
		this.best = best;
	}


	public int getScore() {
		return score;
	}

	private void generate() {
		Random rand = new Random();
		List<Point> points = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 0) {
					points.add(new Point(i, j));
				}
			}
		}

		Point p = points.get(rand.nextInt(points.size()));
		matrix[p.x][p.y] = 2;
	}

	public void initMatrix() {
		Scanner fileIn = null;
		try {
			File file = new File("save");
			fileIn = new Scanner(file);
			score = fileIn.nextInt();
			best = fileIn.nextInt();
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					matrix[i][j] = fileIn.nextInt();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			fileIn.close();
		}
	}
	//保存当前得分，最佳纪录，当前面板到save文件中
	public void save() {
		FileWriter fw = null;
		try {
			File file = new File("save");
			fw = new FileWriter(file);
			fw.write(score + " ");
			fw.write(best + " ");
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					fw.write(matrix[i][j] + " ");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void reStart() {
		matrix = new int[SIZE][SIZE];
		score = 0;
		generate();
		generate();
	}

	private void leftMerge() {
		for (int i = 0; i < SIZE; i++) {
			leftMergeInLine(i);
		}

	}

	private void rightMerge() {
		for (int i = 0; i < SIZE; i++) {
			rightMergeInLine(i);
		}
	}

	private void upMerge() {
		for (int i = 0; i < SIZE; i++) {
			upMergeInLine(i);
		}
	}

	private void downMerge() {
		for (int i = 0; i < SIZE; i++) {
			downMergeInLine(i);
		}
	}

	/*
	 * 将一行中所有可以合并的数字合并，并且计算得分
	 */
	private void leftMergeInLine(int line) {
		// 用于合并操作的第一个元素
		Point p = null;
		for (int i = 0; i < SIZE; i++) {
			// 刚合完或者第一次合成，直接赋值
			if (p == null) {
				if (matrix[line][i] != 0) {
					p = new Point(line, i);
				} else {
					// 0xxx，不理这个0，继续往下看
					continue;
				}
			} else {
				// 相等可以合并
				if (matrix[line][i] == matrix[line][p.y]) {
					score += matrix[line][i] * 2;
					matrix[line][p.y] = 2 * matrix[line][i];
					matrix[line][i] = 0;
					// 将第一个操作数归零
					p = null;
				} else {
					// 2424中间插了4，不用2合了，改用4
					if (matrix[line][i] != 0) {
						p = new Point(line, i);
					} else {
						// 中途遇到0，继续等
						continue;
					}
				}
			}

		}
	}

	private void rightMergeInLine(int line) {
		Point p = null;
		for (int i = SIZE - 1; i >= 0; i--) {
			if (p == null) {
				if (matrix[line][i] != 0) {
					p = new Point(line, i);
				} else {
					continue;
				}
			} else {
				if (matrix[line][i] == matrix[line][p.y]) {
					score += matrix[line][i] * 2;
					matrix[line][p.y] = 2 * matrix[line][i];
					matrix[line][i] = 0;
					p = null;
				} else {
					if (matrix[line][i] != 0) {
						p = new Point(line, i);
					} else {
						continue;
					}
				}
			}

		}
	}

	private void downMergeInLine(int line) {
		Point p = null;
		for (int i = SIZE - 1; i >= 0; i--) {
			if (p == null) {
				if (matrix[i][line] != 0) {
					p = new Point(i, line);
				} else {
					continue;
				}
			} else {
				if (matrix[i][line] == matrix[p.x][line]) {
					score += matrix[i][line] * 2;
					matrix[p.x][line] = 2 * matrix[i][line];
					matrix[i][line] = 0;
					p = null;
				} else {
					if (matrix[i][line] != 0) {
						p = new Point(i, line);
					} else {
						continue;
					}
				}
			}

		}
	}

	private void upMergeInLine(int line) {
		Point p = null;
		for (int i = 0; i < SIZE; i++) {
			if (p == null) {
				if (matrix[i][line] != 0) {
					p = new Point(i, line);
				} else {
					continue;
				}
			} else {
				if (matrix[i][line] == matrix[p.x][line]) {
					score += matrix[i][line] * 2;
					matrix[p.x][line] = 2 * matrix[i][line];
					matrix[i][line] = 0;
					p = null;
				} else {
					if (matrix[i][line] != 0) {
						p = new Point(i, line);
					} else {
						continue;
					}
				}
			}

		}
	}

	private void leftMove() {
		for (int i = 0; i < SIZE; i++) {
			leftMoveInLine(i);
		}
	}

	private void upMove() {
		for (int i = 0; i < SIZE; i++) {
			upMoveInLine(i);
		}
	}

	private void rightMove() {
		for (int i = 0; i < SIZE; i++) {
			rightMoveInLine(i);
		}
	}

	private void downMove() {
		for (int i = 0; i < SIZE; i++) {
			downMoveInLine(i);
		}
	}

	private void leftMoveInLine(int line) {

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[line][i] != 0) {
				for (int j = 0; j < i; j++) {
					if (matrix[line][j] == 0) {
						matrix[line][j] = matrix[line][i];
						matrix[line][i] = 0;
					}
				}
			}
		}
	}

	private void upMoveInLine(int line) {

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][line] != 0) {
				for (int j = 0; j < i; j++) {
					if (matrix[j][line] == 0) {
						matrix[j][line] = matrix[i][line];
						matrix[i][line] = 0;
					}
				}
			}
		}
	}

	private void rightMoveInLine(int line) {

		for (int i = SIZE - 1; i >= 0; i--) {
			if (matrix[line][i] != 0) {
				for (int j = SIZE - 1; j > i; j--) {
					if (matrix[line][j] == 0) {
						matrix[line][j] = matrix[line][i];
						matrix[line][i] = 0;
					}
				}
			}
		}
	}

	private void downMoveInLine(int line) {

		for (int i = SIZE - 1; i >= 0; i--) {
			if (matrix[i][line] != 0) {
				for (int j = SIZE - 1; j > i; j--) {
					if (matrix[j][line] == 0) {
						matrix[j][line] = matrix[i][line];
						matrix[i][line] = 0;
					}
				}
			}
		}
	}

	private void showMatrix() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.printf("%-5d", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("score: " + score);
	}

}
