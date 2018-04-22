package com.honghe03;

public class Dirver {
	Car car;
	void buy(Car c) {
		System.out.println("我买了一辆" +  c.brand);
		car = c;
	}
	Car change() {
		car.color = "蓝色";
		System.out.println("我把它改装成了" + car.color);
		return car;
	}
}
