package com.gaojingUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends Sprite {

	//方向
	private int direction;
	
	//子弹图片
	private static BufferedImage[] imgs;
	
	static {
		
		try {
			BufferedImage up = ImageIO.read(new File("bulletUp.png"));
			BufferedImage right = ImageIO.read(new File("bulletRight.png"));
			BufferedImage down = ImageIO.read(new File("bulletDown.png"));
			BufferedImage left = ImageIO.read(new File("bulletLeft.png"));
			imgs = new BufferedImage[] {up, right, down, left};
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Bullet(int x, int y, int width, int height, int speed, int direction) {
		super(x, y, width, height, speed);
		this.direction = direction;
	}
	@Override
	public void move() {
		if(direction == 0) {
			setY(getY() - getSpeed());
		}else if(direction == 1) {
			setX(getX() + getSpeed());
		}else if(direction == 2) {
			setY(getY() + getSpeed());
		}else {
			setX(getX() - getSpeed());
		}
	}

	@Override
	public BufferedImage getImage() {
		return imgs[direction];
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
	@Override
	protected int getSafeDistanceAdjustValue() {
		return -2;
	}

}
