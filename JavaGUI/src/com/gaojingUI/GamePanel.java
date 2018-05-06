package com.gaojingUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	// 定义英雄对象
	private Hero hero;

	// 定义背景图片
	private static BufferedImage bgImg;

	// 定义游戏标题图片
	private static BufferedImage titleImg;

	// 定义按钮开启图片
	private static BufferedImage startImg;

	//定义游戏结束时需要绘制的图片
	private static BufferedImage overImg;
	private static BufferedImage restartImg;
	
	// 定义游戏状态， 0表示游戏准备 1表示游戏开始 2表示游戏结束
	private int status = 0;

	//游戏得分
	private int score;

	private Timer timer;

	// 定义变量用于记录定时器的执行时间
	private long milliseconds;

	// 定义存储子弹的数组
	private Bullet[] bullets;

	// 定义存储敌人的数组
	private Enemy[] enemys;

	static {
		try {
			bgImg = ImageIO.read(new File("bg1.png"));
			titleImg = ImageIO.read(new File("gameTitle.png"));
			startImg = ImageIO.read(new File("gameStart.png"));
			
			overImg = ImageIO.read(new File("gameOver.png"));
			restartImg = ImageIO.read(new File("gameRestart.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//
	public GamePanel() {
		//初始化操作
		init();
	}
	
	// 初始化游戏操作
	public void init() {
		// 初始化英雄
		hero = new Hero(400, 250, 48, 72, 5, 1);
		milliseconds = 0;

		// 初始化子弹数组
		bullets = new Bullet[] {};

		// 初始化敌人数组
		enemys = new Enemy[] {};
		
		score = 0;
		
		//获取所有的键盘按键监听器
		KeyListener[] ks = this.getKeyListeners();
		for (int i = 0; i < ks.length; i++) {
			//移除键盘按键监听器
			this.removeKeyListener(ks[i]);
		}
		
		//获取所有的鼠标移动监听器
		MouseMotionListener[] ms = this.getMouseMotionListeners();
		for (int i = 0; i < ms.length; i++) {
			//移除鼠标移动监听器
			this.removeMouseMotionListener(ms[i]);
		}
	}

	// 游戏准备
	public void prepare() {
		status = 0;
		// 重新绘制
//		repaint();

		this.setFocusable(true);
		this.requestFocus();
		
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (status == 0 || status == 2) {
						start();
					}
				}
			}
		});
	}

	// 游戏开始的方法
	public void start() {
		status = 1;
		// 游戏开始先进行初始化操作
		init();
		// 设置面板可以获取焦点
		this.setFocusable(true);
		// 让当前面板获取焦点
		this.requestFocus();
		// 初始化定时器对象
		timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {

				if (milliseconds % 150 == 0) {
					hero.flicker();
				}

				// 英雄移动
				if (milliseconds % 40 == 0) {
					hero.move();
				}

				// 发射子弹
				if (milliseconds % 250 == 0) {
					heroShoot();
				}

				// 子弹移动
				if (milliseconds % 50 == 0) {
					bulletMove();
				}

				// 清除越界的精灵
				if (milliseconds % 150 == 0) {
					clearOutside();
				}
				// 敌人出场
				if (milliseconds % 1000 == 0) {
					enemyEnter();
				}

				// 敌人移动
				if (milliseconds % 50 == 0) {
					enemyMove();
				}
				// 检测敌人和英雄碰撞
				if (milliseconds % 50 == 0) {
					checkEnemyHitHero();
					checkBulletHitEnemy();
				}
				//清除边界外的子弹和敌人
				if (milliseconds % 150 == 0) {
					clearOutside();
				}
				// 重新绘制
				repaint();
				milliseconds += 10;
			}
		}, 0, 10);

		// 给面板添加鼠标移动的事件监听
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {

				//
				int distanceX = e.getX() - hero.getX();
				int distanceY = e.getY() - hero.getY();

				if (Math.abs(distanceX) > Math.abs(distanceY)) {
					// if
					if (distanceX > 0) {
						// 方向向右
						hero.setDirection(1);
					} else {
						// 方向向左
						hero.setDirection(3);
					}

				} else {
					if (distanceY > 0) {
						// 方向向下
						hero.setDirection(2);
					} else {
						// 方向向上
						hero.setDirection(0);
					}
				}

			}

			@Override
			public void mouseDragged(MouseEvent e) {

			}
		});

		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
				case KeyEvent.VK_W:
					hero.setOffsetY(0);
					break;

				case KeyEvent.VK_RIGHT:
				case KeyEvent.VK_D:
					hero.setOffsetX(0);
					break;

				case KeyEvent.VK_DOWN:
				case KeyEvent.VK_S:
					hero.setOffsetY(0);
					break;

				case KeyEvent.VK_LEFT:
				case KeyEvent.VK_A:
					hero.setOffsetX(0);
					break;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// 按压时处理
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
				case KeyEvent.VK_W:
					hero.setDirection(0);
					hero.setOffsetY(-1 * hero.getSpeed());
					break;

				case KeyEvent.VK_RIGHT:
				case KeyEvent.VK_D:
					hero.setDirection(1);
					hero.setOffsetX(1 * hero.getSpeed());
					break;

				case KeyEvent.VK_DOWN:
				case KeyEvent.VK_S:
					hero.setDirection(2);
					hero.setOffsetY(1 * hero.getSpeed());
					break;

				case KeyEvent.VK_LEFT:
				case KeyEvent.VK_A:
					hero.setDirection(3);
					hero.setOffsetX(-1 * hero.getSpeed());
					break;
				}
			}
		});

	}

	public void paint(Graphics g) {

		if (status == 0) {
			// 游戏准备中
			g.drawImage(bgImg, 0, 0, 800, 500, null);
			g.drawImage(titleImg, 170, 120, 460, 120, null);
			g.drawImage(startImg, 249, 320, 303, 26, null);
			
		} else {
			
			//// 绘制游戏
			g.drawImage(bgImg, 0, 0, 800, 500, null);

			int x = hero.getX() - hero.getWidth() / 2;
			int y = hero.getY() - hero.getHeight() / 2;
			// 绘制英雄图片
			g.drawImage(hero.getImage(), x, y, hero.getWidth(), hero.getHeight(), null);

			// 绘制子弹
			for (int i = 0; i < bullets.length; i++) {
				Bullet b = bullets[i];
				x = b.getX() - b.getWidth() / 2;
				y = b.getY() - b.getHeight() / 2;

				g.drawImage(b.getImage(), x, y, b.getWidth(), b.getHeight(), null);
			}

			// 绘制敌人
			for (int i = 0; i < enemys.length; i++) {
				Enemy e = enemys[i];
				x = e.getX() - e.getWidth() / 2;
				y = e.getY() - e.getHeight() / 2;

				g.drawImage(e.getImage(), x, y, e.getWidth(), e.getHeight(), null);
			}
			
			//绘制分数
			g.setColor(new Color(255, 255, 255));
			g.setFont(new Font("微软雅黑", Font.BOLD, 20));
			g.drawString("score : " + score, 20, 30);
			//
			if (status == 2) {
				g.drawImage(overImg, 160, 140, 480, 65, null);
				g.drawImage(restartImg, 267, 320, 269, 26, null);
			}
		}
	}

	// 发射子弹存储到数组中
	public void heroShoot() {
		Bullet b = hero.shoot();
		bullets = Arrays.copyOf(bullets, bullets.length + 1);
		bullets[bullets.length - 1] = b;
	}

	// 子弹移动
	public void bulletMove() {
		for (int i = 0; i < bullets.length; i++) {
			bullets[i].move();
		}
	}

	// 清除越界子弹
	public void clearOutside() {
		Bullet[] bs = new Bullet[bullets.length];
		int index = 0;
		for (int i = 0; i < bullets.length; i++) {
			if (!bullets[i].isOutside()) {
				bs[index++] = bullets[i];
			}
		}
		bullets = Arrays.copyOf(bs, index);

		// 清除越界敌人
		Enemy[] es = new Enemy[enemys.length];
		index = 0;
		for (int i = 0; i < enemys.length; i++) {
			if (!enemys[i].isOutside()) {
				es[index++] = enemys[i];
			}
		}
		enemys = Arrays.copyOf(es, index);

	}

	// 敌人移动
	public void enemyMove() {
		for (int i = 0; i < enemys.length; i++) {
			enemys[i].setTargetX(hero.getX());
			enemys[i].setTargetY(hero.getY());
			enemys[i].move();
		}
	}

	// 生成敌人
	public void enemyEnter() {
		Enemy e = null;
		int randomX = (int) (Math.random() * 800);
		int randomY = (int) (Math.random() * 500);
		int r = (int) (Math.random() * 4);
		switch (r) {
		case 0:
			e = new Enemy(randomX, 0, 50, 50, 3);
			break;

		case 1:
			e = new Enemy(800, randomY, 50, 50, 3);
			break;

		case 2:
			e = new Enemy(randomX, 500, 50, 50, 3);
			break;

		case 3:
			e = new Enemy(0, randomY, 50, 50, 3);
			break;

		default:
			break;
		}
		enemys = Arrays.copyOf(enemys, enemys.length + 1);
		enemys[enemys.length - 1] = e;
	}

	// 检测子弹和敌人的碰撞
	public void checkBulletHitEnemy() {
		for (int i = bullets.length - 1; i >= 0; i--) {
			Bullet b = bullets[i];
			for (int j = enemys.length - 1; j >= 0; j--) {
				Enemy e = enemys[j];
				if (b.hit(e)) {
					b.setX(2000);
					e.setX(2000);
					//每次击中敌人分数增加100分
					score += 100;
				}
			}
		}
	}

	// 游戏结束的方法
	public void over() {
		status = 2;
		timer.cancel();
		repaint();
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					start();
				}
			}
		});
	}

	// 检测敌人碰撞英雄
	public void checkEnemyHitHero() {
		for (int i = 0; i < enemys.length; i++) {
			if (enemys[i].hit(hero)) {
				over();
				break;
			}
		}
	}
}
