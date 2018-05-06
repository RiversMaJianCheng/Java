package com.gaojingUI;

import javax.swing.JFrame;

public class Game {

	public static void main(String[] args) {

		JFrame frame = new JFrame("龙龙大作战");
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		// 让窗体不可以改变大小
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GamePanel panel = new GamePanel();
		frame.add(panel);
		frame.setVisible(true);
		panel.prepare();
	}
}
