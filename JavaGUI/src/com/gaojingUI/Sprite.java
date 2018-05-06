package com.gaojingUI;

import java.awt.image.BufferedImage;

public abstract class Sprite {

	private int x;
	private int y;
	private int width;
	private int height;
	private int speed;
	
	public Sprite(int x, int y, int width, int height, int speed) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	//抽象的移动方法
	public abstract void move();
	public abstract BufferedImage getImage();
	
	//判断精灵是否超出屏幕
	 public boolean isOutside() {
		 if(getY() + getHeight() / 2 < 0) {
				return true;
			}
			if(getY() - getHeight() / 2 > 500) {
				return true;
			}
			if(getX() - getWidth() / 2 > 800) {
				return true;
			}
			if(getX() + getWidth() / 2 < 0) {
				return true;
			}
			
			return false;
	 } 

	//碰撞检测
	public boolean hit(Sprite target) {
		if(target == null) {
			return false;
		}
		int distanceX = Math.abs(getX() - target.getX());
		int distanceY = Math.abs(getY() - target.getY());
		
		int adjust = this.getSafeDistanceAdjustValue();
		int adjust1 = target.getSafeDistanceAdjustValue();
		
		int safeX = getWidth() / 2 + target.getWidth() / 2 + adjust1;
		int safeY = getHeight() / 2 + target.getHeight() / 2 + adjust1;
		if (distanceX < safeX && distanceY < safeY) {
			return true;
		} else {
			return false;
		}
	}
	
	protected int getSafeDistanceAdjustValue() {
		return 0;
	}
}
