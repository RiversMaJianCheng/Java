package javaBase;

import java.util.Scanner;

public class JavaBase02 {

	public static void main(String[] args) {
		
		//输入三角形的底和高求面积
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入三角形的底：");
		float di = scanner.nextFloat();
		while (di < 0) {
			System.out.println("三角形的底不能小于0，请重新输入");
			di = scanner.nextFloat();
		}
		System.out.println("请输入三角形的高：");
		float h = scanner.nextFloat();
		while (h < 0) {
			System.out.println("三角形的高不能小于0，请重新输入");
			h = scanner.nextFloat();
		}
		//计算三角形的面积
		double s = di * h / 2.0;
		System.out.println("三角形的面积是：" + s);
		
		//输入圆锥的底面半径和高求体积
		//圆锥的体积
		System.out.println("请输入圆锥的底面半径：");
		float coneR = scanner.nextFloat();
		while(coneR < 0) {
			System.out.println("圆锥的底面半径不能小于0，请重新输入：");
			coneR = scanner.nextFloat();
		}
		System.out.println("请输入圆锥的高：");
		float coneH = scanner.nextFloat();
		while(coneH < 0) {
			System.out.println("圆锥的高不能小于0，请重新输入：");
			coneH = scanner.nextFloat();
		}
		double coneV = coneR * coneR * 3.14 * coneH / 3.0;
		System.out.println("圆锥的体积是：" + coneV);
		
	}

}
