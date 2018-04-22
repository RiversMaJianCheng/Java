package com.honghe05;

public class Game {
	/*
	 * 1. 定义修理工类。 作业 - 要求包含工资属性，并对该属性进行封装处理。 - 增加构造器，用于初始化工资属性，在初始化时保证工资不能小于 0。 - 在
	 * set 方法里，同样检查工资，保证工资不能小于 0。 - 开发游戏程序，在 main 方法里创建修理工，给他设置小于 0 的工资，然
	 * 后打印修理工的工资信息。
	 */

	/*
	 * 2. 为修理工增加吃饭的行为。 - 定义人类，类中增加姓名属性，和吃饭方法。方法内打印“XXX 在吃饭”。 - 让修理工继承于人类。 - 在 main
	 * 方法里，调用修理工的吃饭方法。
	 */
	public static void main(String[] args) {
		RepairMan r = new RepairMan(1000);
		r.setSalary(-2000);
		System.out.println("工资是：" + r.getSalary());
		r.name = "张三";
		r.eat();
	}

}
