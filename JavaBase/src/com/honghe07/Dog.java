package com.honghe07;

public class Dog extends Animal implements Explorer {

	@Override
	void eat() {
		System.out.println("狗爱啃骨头");
	}

	@Override
	public void explor() {
		System.out.println("狗擅长探测");
	}

}
