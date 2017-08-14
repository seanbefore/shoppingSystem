package tools;

import java.util.Scanner;

//从键盘上获取字符串，数字等

public class ScannerChoice{
	
	//保留两位的浮点数
	public static float ScannerPrice(){
		float price = 0.00;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("保留小数点后两位，输入：")；
			String p = sc.next();
			String pattern = "([1-9][0-9]*)\\.([0-9]{2}|[0]\\.([0-9]{2})";
			if ( p.maches(pattern)){
				price = Float.parseFloat(p);
			}else{
				System.out.print("输入格式错误！")；
				continue;
			}
		}while(true);
		return price;
	}
	
	//整数
	public static float ScannerNum(){
		int num = 0;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("输入整数：")；
			String p = sc.next();
			String pattern = "[1-9][0-9]*";
			if ( p.maches(pattern)){
				num = Integer.parseInt(p);
			}else{
				System.out.print("输入格式错误！")；
				continue;
			}
		}while(true);
		return num;
	}
	
	//字符串
	public static String ScannerString(){
		Scanner sc = new Scanner(System.in);
		System.out.print("输入字符串：")；
		return sc.next();
	}
	
	//输入Y 或 N
	public static bool ScannerBool(){
		
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("是否继续（Y/N）：")；
			String p = sc.next();
			String py = "[yY]";
			String pn = "[nN]";
			if ( p.maches(py)){
				return true;
			}elseif(p.maches(pn)){
				return false;
			}else{
				System.out.print("输入格式错误！")；
				continue;
			}
		}while(true);
		return num;
	}
}