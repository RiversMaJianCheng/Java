package com.gaojingUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hero extends Sprite {


	// 英雄的方向
	private int direction;
	//英雄四个方向图片的数组
	
	//英雄X轴的偏移量
	private int offsetX;
	//英雄Y轴的偏移量
	private int offsetY;
	//数组的索引
	private  int imgIndex = 0;
	
	private static BufferedImage[][] images;

	
	private static BufferedImage[] upImgs;
	private static BufferedImage[] rightImgs;
	private static BufferedImage[] downImgs;
	private static BufferedImage[] leftImgs;


	
	static {
		try {
			BufferedImage imageUp0 = ImageIO.read(new File("heroUp0.png"));
			BufferedImage imageUp1 = ImageIO.read(new File("heroUp1.png"));
			BufferedImage imageUp2 = ImageIO.read(new File("heroUp2.png"));
			
			BufferedImage imageRight0 = ImageIO.read(new File("heroRight0.png"));
			BufferedImage imageRight1 = ImageIO.read(new File("heroRight1.png"));
			BufferedImage imageRight2 = ImageIO.read(new File("heroRight2.png"));
			
			BufferedImage imageDown0 = ImageIO.read(new File("heroDown0.png"));
			BufferedImage imageDown1 = ImageIO.read(new File("heroDown1.png"));
			BufferedImage imageDown2 = ImageIO.read(new File("heroDown2.png"));
			 
			BufferedImage imageLeft0 = ImageIO.read(new File("heroLeft0.png"));
			BufferedImage imageLeft1 = ImageIO.read(new File("heroLeft1.png"));
			BufferedImage imageLeft2 = ImageIO.read(new File("heroLeft2.png"));
			upImgs = new BufferedImage[] {imageUp0,imageUp1,imageUp2};
			rightImgs = new BufferedImage[]{imageRight0,imageRight1,imageRight2};
			downImgs = new BufferedImage[]{imageDown0,imageDown1,imageDown2};
			leftImgs = new BufferedImage[]{imageLeft0,imageLeft1,imageLeft2};
			images = new BufferedImage[][] {upImgs,rightImgs,downImgs,leftImgs};
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//	构造方法
	public Hero(int x, int y, int width, int height, int speed, int direction) {
		super(x, y, width, height, speed);
		this.direction = direction;
	}

	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}

	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}


	public  BufferedImage getImage() {
		return images[direction][imgIndex];
		
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public void flicker() {
		imgIndex = ++imgIndex % images[direction].length;
	}
	
	public void move() {
		setX(getX() + offsetX);
		setY(getY() + offsetY);
	}
	
	//英雄射击的方法
	public Bullet shoot() {
		//定义子弹中心坐标点
		int bx = 0;
		int by = 0;
		
		//根据方向算出中心点
		if(direction == 0) {
			//上
			bx = getX();
			by = getY() - getHeight() / 2;
		}else if(direction == 1) {
			//右
			bx = getX() + getWidth() / 2;
			by = getY();
		}else if(direction == 2) {
			//下
			bx = getX() ;
			by = getY() + getHeight() / 2;
		}else {
			//左
			bx = getX() - getWidth() / 2;
			by = getY();
		}
		return new Bullet(bx, by, 27, 27, 25, direction);
	}

	@Override
	protected int getSafeDistanceAdjustValue() {
		return -10;
	}


}
