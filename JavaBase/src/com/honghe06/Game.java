package com.honghe06;

public class Game {

	public static void main(String[] args) {

		/*
		 * 对象的类型转换 子类型可以直接转为父类型: Vehicle v = new Truck(); 父类型可以强制转换为子类型: Truck t =
		 * (Truck) v;
		 */
		/*
		 * 1. 模拟开发一款宠物赛跑游戏，定义如下的类。 - 定义动物类，增加名字属性，奔跑方法，方法内打印“XXX 跑的快!”。 -
		 * 定义猫类、狗类，继承于动物类。 - 定义鱼类，继承于动物类，重写奔跑方法，方法内打印“XXX 游的快!”。 - 开发游戏程序，在 main
		 * 方法内创建猫、狗、鱼对象，调用它们的奔跑方 法。
		 */

		/*
		 * 2. 完善宠物赛跑游戏。 - 定义人类，增加训练的方法，参数为动物类型。在此方法内调用动物的奔 跑方法。 - 修改游戏程序，在 main
		 * 方法内创建人对象，并调用它的训练方法，让他 依次训练猫、狗、鱼。
		 */
		
		Cat c = new Cat();
		Dog d = new Dog();
		Fish f = new Fish();
		
		c.name = "毛";
		d.name = "狗";
		f.name = "鱼";
		
		c.run();
		d.run();
		f.run();
		
		People p = new People();
		p.train(c);
		p.train(d);
		p.train(f);
	}

}
