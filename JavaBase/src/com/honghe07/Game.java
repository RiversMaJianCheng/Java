package com.honghe07;

public class Game {

	public static void main(String[] args) {
		/*
		 * 1. 模拟开发一款动物探险游戏，定义如下的类。 - 定义抽象的动物类，增加抽象的“吃”方法。 -
		 * 定义猫、狗、鼠类，继承于动物类，分别实现吃方法，方法内打印信息形 如“猫爱吃鱼!”。 - 定义人类，增加喂养方法，参数为动物。 - 开发游戏程序，在
		 * main 方法中依次创建猫、狗、鼠、人对象，并调用人 的喂养方法，依次喂养猫、狗、鼠。
		 */
		/*
		 * 2. 完善动物探险游戏。 - 定义探测者接口，增加探测方法。 - 让狗类、鼠类实现探测者接口，探测方法内打印信息如“狗擅长探测!”。 -
		 * 在人类中增加搜索方法，传入参数为探测者接口。搜索方法内调用该接口 的探测方法即可。 - 在 main 方法中调用人的搜索方法 2 次，分别传入狗、鼠。
		 */
		Cat c = new Cat();
		Dog d = new Dog();
		Mouse m = new Mouse();
		People p = new People();
		p.feed(c);
		p.feed(d);
		p.feed(m);
		
		p.search(d);
		p.search(m);
	}

}
