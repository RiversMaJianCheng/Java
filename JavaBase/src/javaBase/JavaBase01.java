package javaBase;

public class JavaBase01 {

	public static void main(String[] args)  throws Exception{

		//经本人测试根本关不了机，难道是因为Mac系统不一样？？？sudo shutdown -h 1401092330
		//经确认Mac无法关机，下段关机代码只是针对Windows电脑有效
		Runtime.getRuntime().exec("shutdown -s -t 10");
	}

}
