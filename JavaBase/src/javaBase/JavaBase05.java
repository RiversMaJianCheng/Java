package javaBase;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JavaBase05 {

	public static void main(String[] args) {
		/*
		回文数判断
		控制台输入一个 5 位数，判断它是不是回文数。个位与万位相同，十位与千位
		相同。 例如:12321 89898 都是回文数。
		*/
		huiwenDigtal();
		
		/*
		新建一个可以存放 6 个整数元素的数组(int[])，并随机生成 100 以内的随机数 对每个元素进行初始化。输出这个数组。
		将这个数组逆序输出。
		*/
		arrayPrint();
		
	}
	static void huiwenDigtal() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个五位数：");
		int number = scanner.nextInt();
		while(String.valueOf(number).length() != 5) {
			System.out.println("输入的数据有误，请重新输入5位数：");
			number = scanner.nextInt();
		}
		//创建一个数组来接受这五个数
		int array[] = new int[5];
		int i = 0;
		do {
		array[i] = number % 10;
		number = number / 10;
			i++;
		}while(i < 5);
		
		if(array[0] == array[4] && array[1] == array[3]) {
			System.out.println("输入的数字是回文数字");
		}else {
			System.out.println("输入的数字不是回文数字");
		}
	}
	
	 static void arrayPrint() {
		 
		 int[] array= new int[6];
		 Random random = new Random();
		 //将生成的数据加入数组中
		 for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
		}
		 System.out.println("生成的数组为：" + Arrays.toString(array));

		 //开始将数组逆序然后输入
		 for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
		 System.out.println("逆序后生成的数组为：" + Arrays.toString(array));
	 }
}
