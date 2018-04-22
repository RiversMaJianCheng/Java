package com.honghe03;

public class Game {

	public static void main(String[] args) {
		Car c = new Car("奔驰", "红色");
		Dirver d = new Dirver();
		d.buy(c);
		c = d.change();
		System.out.println(c.brand);
		System.out.println(c.color);
	}

}
