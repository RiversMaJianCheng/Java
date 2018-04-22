package javaBase;

public class JavaBase04 {

	public static void main(String[] args) {
//		输出 9*9 乘法表，效果如下:
		table();
		/*
		有 1、2、3、4 个数字，能组成多少个互不相同且无重复数字的三位数?都是多 少?
		(要求每输出 10 个数字就换一行)
		 */
		group();
		
	}
	static void table() {
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(j+"*"+i + "=" + i*j + "   ");
			}
			System.out.println();
		}
	}
	static void group() {
		int count = 0;
		for(int i = 1; i < 5; i++) {
			for(int j = 1; j < 5; j++) {
				for(int k = 1; k < 5; k++) {
					if(i != j && i != k && j != k) {
						System.out.print("" +i+j+k + "   ");
						count++;
						if(count % 10 == 0) {
							System.out.println();
						}
					}
				}
			}
		}
		System.out.println();
		System.out.println("一共有" + count + "组数据");
	}
}
