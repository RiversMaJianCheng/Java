package javaBase;

import java.util.Scanner;

public class JavaBase03 {

	public static void main(String[] args) {
		
		/*
		 * 控制台输入消费金额，根据如下规则计算折扣后输出应付金额: 满100打9折;
			满500打8折;
			满2000打6折;
			满5000打4折; 程序结果如下:
		 * */
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入消费金额：");
		float money = scanner.nextFloat();
		while(money < 0) {
			System.out.println("输入的金额不合法，请重新输入：");
			money = scanner.nextFloat();
		}
		float result = money(money);
		System.out.println("您需支付：" + result + "元");
		
		
		//计算闰年与否
		/*控制台输入年份，根据如下规则判断该年份是否为闰年:
		必须能被 4 整除。
 		如果逢百年则必须能被 400 整除。
		满足上述两个条件的年份则为闰年，如 1900 年不是闰年，因为不符合第二个条 件;1904 年、2000 年则符合上述两个条件，即为闰年。
		 * */
		System.out.println("请输入年份：");
		int year = scanner.nextInt();
		String resultY = year(year);
		System.out.println(resultY);
		
	}
	static float money(float m) {
		if(m < 100) {
			return m;
		}else if(m < 500) {
			return (float) (m * 0.9);
		}else if(m < 2000) {
			return (float) (m * 0.8);
		}else if(m < 5000) {
			return (float) (m * 0.6);
		}else {
			return (float) (m * 0.4);
		}
	}
	
	static String year(int y) {
		if(y % 100 != 0) {
			if(y % 4 == 0) {
				return y + "是闰年";
			}else {
				return y + "不是闰年";
			}
		}else {
			if(y % 400 == 0) {
				return y + "是闰年";
			}else {
				return y + "不是闰年";
			}
		}
	}
}