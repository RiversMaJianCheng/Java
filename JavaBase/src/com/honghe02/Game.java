package com.honghe02;

public class Game {

	public static void main(String[] args) {
		Feeder f = new Feeder("张三", 28, '男');
		Horse h = new Horse("汗血宝马", "棕色", 5, '雄');
		f.buyHorse(h);
	}

}
