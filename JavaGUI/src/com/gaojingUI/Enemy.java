package com.gaojingUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends Sprite {

	@Override
	protected int getSafeDistanceAdjustValue() {
		return -10;
	}

	// 定义敌人移动的目标坐标点
	private int targetX;
	private int targetY;
	//敌人的图片
	private static BufferedImage img;
	
	//加载图片
	static {
		try {
			img = ImageIO.read(new File("enemy.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Enemy(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
	}

	public int getTargetX() {
		return targetX;
	}

	public void setTargetX(int targetX) {
		this.targetX = targetX;
	}

	public int getTargetY() {
		return targetY;
	}

	public void setTargetY(int targetY) {
		this.targetY = targetY;
	}

	@Override
	public void move() {
		int distanceX = targetX - getX();
		int distanceY = targetY - getY();
		int distance = (int) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
		int m = getSpeed() * distanceX / distance;
		int n = getSpeed() * distanceY / distance;
		setX(getX() + m);
		setY(getY() + n);
	}

	@Override
	public BufferedImage getImage() {
		return img;
	}

	@Override
	public boolean isOutside() {
		if(getX() + getWidth() / 2 < 0) {
			return true;
		}else if(getX() - getWidth() / 2 > 800) {
			return true;
		}else if(getY() + getHeight() / 2 < 0) {
			return true;
		}else if(getY() - getHeight() / 2 > 500) {
			return true;
		}
		return false;	
	}

}
