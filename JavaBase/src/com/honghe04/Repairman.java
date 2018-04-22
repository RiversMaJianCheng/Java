package com.honghe04;

public class Repairman {
	String name;
	int age;
	char sex;
	public Repairman(String name) {
		this.name = name;
	}
	public Repairman(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Repairman(String name,int age, char sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	void repair(Car c) {
		System.out.println(this.name + "会修理小汽车");
	}
	void repair(Truck t) {
		System.out.println(this.name + "会修理大卡车");
	}
	void repair(Bus b) {
		System.out.println(this.name + "会修理公交车");
	}
}
