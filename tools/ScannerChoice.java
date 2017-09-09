package tools;

import java.util.Scanner;

//从键盘上读取内容

public class ScannerChoice{
	
	//读取价格
	public static float ScannerPrice(){
		float price = (float) 0.00;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("输入，保留小数点后两位：");
			String p = sc.next();
			String pattern = "([1-9][0-9]*)\\.([0-9]{2}|[0]\\.([0-9]{2})";
			if ( p.matches(pattern)){
				price = Float.parseFloat(p);
				break;
			}else{
				System.out.print("输入错误！");
				continue;
			}
		}while(true);
		return price;
	}
	
	//读整数
	public static int ScannerNum(){
		int num = 0;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("输入整数：");
			String p = sc.next();
			String pattern = "[1-9][0-9]*";
			if ( p.matches(pattern)){
				num = Integer.parseInt(p);
				break;
			}else{
				System.out.print("输入有误！");
				continue;
			}
		}while(true);
		return num ;
	}
	
	//输入字符串
	public static String ScannerString(){
		Scanner sc = new Scanner(System.in);
		System.out.print("输入：");
		return sc.next();
	}
	
	//输入布尔值
	@SuppressWarnings("resource")
	public static boolean ScannerBool(){
		try{
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("是否继续进行-当前操作:(Y/N)");
			String p = sc.next();
			String py = "[yY]";
			String pn = "[nN]";
			if ( p.matches(py)){
				return true;
			}else if(p.matches(pn)){
				return false;
			}else{
				System.out.print("输入有误！请重新输入.");
				continue;
			}
		}while(true);
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return false;
	}
}