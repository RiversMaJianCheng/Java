package com.honghe07;

public class Mouse extends Animal implements Explorer {

	@Override
	void eat() {
		System.out.println("老鼠爱吃大米");
	}

	@Override
	public void explor() {
		System.out.println("老鼠擅长打地洞");
	}

}
