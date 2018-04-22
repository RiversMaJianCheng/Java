package com.honghe02;

public class Feeder {
	String name;
	int age;
	char sex;
	String idNumber;
	Feeder(String n, int a, char s){
		name = n;
		age = a;
		sex = s;
		idNumber = "";
		idNumber += System.currentTimeMillis();
		idNumber += (int)(Math.random() * 10);
		idNumber += (int)(Math.random() * 10);
		idNumber += (int)(Math.random() * 10);
		idNumber += (int)(Math.random() * 10);
	}
	void buyHorse(Horse h) {
		System.out.println("我叫：" + name);
		System.out.println("今年：" + age);
		System.out.println("性别：" + sex);
		System.out.println("身份证号：" + idNumber);
		
		System.out.println("今天我买了一匹" + h.type);
		System.out.println("它的颜色：" + h.color);
		System.out.println("它的年龄：" + h.age);
		System.out.println("它的性别：" + h.sex + "性");
	}
}
