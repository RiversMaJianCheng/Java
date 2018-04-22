package com.honghe04;

public class Game {
	/*
	 * 1. 定义修理工类。 作业 - 要求包含姓名、年龄、性别三个属性。 - 声明 3 个构造器，用于初始化修理工。第 1 个构造器用于初始化姓名，第 2
	 * 个构造器用于初始化姓名、年龄，第 3 个构造器用于初始化姓名、年龄、 性别。 - 要求构造器的参数名与属性同名，并且要尽可能的采用 this 关键字，调用
	 * 其它构造器，以复用代码。 - 开发游戏程序，在 main 方法中选择参数最多的构造方法创建修理工对象。 - 打印该对象的信息，打印信息的格式参考下图。
	 */
	/*
	 * 2. 修改修理工类，让他具备修理行为。 - 定义小汽车类、卡车类、公交车类。 - 在修理工类中增加3个同名的修理方法，分别用于修理小汽车、卡车、公
	 * 交车，修理方法内用打印一句话模拟修理行为即可，格式参考下图。 - 要求方法内使用this关键字来引用成员变量。 -
	 * 在游戏程序的main方法中，创建小汽车、卡车、公交车对象。 - 调用修理工的修理方法，依次修理小汽车、卡车、公交车。
	 */
	public static void main(String[] args) {
		Repairman r = new Repairman("张三", 35, '男');
		System.out.println(r.name);
		System.out.println(r.age);
		System.out.println(r.sex);

		Car c = new Car();
		Truck t = new Truck();
		Bus b = new Bus();
		r.repair(c);
		r.repair(t);
		r.repair(b);
	}

}
