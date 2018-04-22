package javaBase;

import java.util.Scanner;

public class JavaBase06 {

	public static void main(String[] args) {
		//求最小公倍数
		/*编写一个方法 getCM(int m, int n)，接受 m,n 两个整数参数，求其最小公倍数并 返回。
		main 方法中在控制台输入 m 与 n，然后调用该方法获得最小公倍数并输出。
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入第一个数的值：");
		int m = scanner.nextInt();
		System.out.println("请输入第二个数的值：");
		int n = scanner.nextInt();
		getCM(m, n);
		
		/*
		 * 18 位身份证验证算法
		18 位身份证号的最后一位是通过前 17 位计算得出，算法如下:
		1. 把身份证号前 17 位的每一位分别乘以不同的系数，前 17 位中每一位数字对 应的系数如下:7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
		2. 把每一位数字与系数的乘积结果相加求和。
		3. 把上一步的结果除以 11，余数只可能是 0，1，2，3，4，5，6，7，8，9， 10这11个数字。
		4. 这 11 个数字分别对应的最后一位字符是: 1 0 X 9 8 7 6 5 4 3 2 (如果余数为 2，则身份证最后一位字符则为 X)
		*/
		System.out.println("请输入18位身份证号：");
		String string = scanner.next();
		while(string.length() != 18) {
			System.out.println("中国人身份证号只有18位，请重新输入：");
			string = scanner.next();
		}
		chargeIDCard(string);
	}
	static void getCM(int m, int n) {
		int count = 0;
		if(m > n) {
			count = m;
		}else {
			count = n;
		}
		for (int i = count; i <= m * n; i++) {
			if(count % m == 0 && count % n == 0) {
				System.out.println(m +"和"+n + "的最小公倍数是" + count);
				break;
			}
			count++;
		}
	}
	static void chargeIDCard(String string) {
		int[] ratio = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
		int sum = 0;
		for (int i = 0; i < ratio.length; i++) {
			sum += ratio[i] * (string.charAt(i) - '0');
		}
		int resutl = sum % 11;
		char[] arrayResult = {'1','0','X','9','8','7','6','5','4','3','2'};
		if(arrayResult[resutl] == string.charAt(17)) {
			System.out.println("输入的身份证是合法的");
		}else {
			System.out.println("输入的身份证是非法的");
		}
	}
}
