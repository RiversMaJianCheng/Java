package javaBase2;

public class Feeder {
	//姓名
	String name;
	//年龄
	int age;
	
	void eat(Horse h) {
		System.out.println(this.name + "在喂马");
		h.eat();
	}
	
	void ride(Horse h) {
		System.out.println(this.name + "在骑马");
		h.run();
	}
	
	void introduce(Horse h) {
		System.out.println("这是一匹" + h.type);
		System.out.println("毛色" + h.color);
		System.out.println("它今年" + h.age + "岁");
		System.out.println("它是一匹" + h.sex + "马");
	}
	
}
