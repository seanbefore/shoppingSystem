package page;
import java.util.*;

import db.*;
import entity.*;
import tools.*;
public class MainPage {

		public static void main(String[] args) {
			MainPage.mainPage();
		}
		public static void mainPage(){
			System.out.println("***************************\n");
			System.out.println("\t 1.商品维护\n");
			System.out.println("\t 2.前台收银\n");
			System.out.println("\t 3.商品管理\n");
			System.out.println("***************************");
			
			System.out.println("\n请输入选项,或者按0退出.");
			do{
				String choice=ScannerChoice.ScannerString();
				String regex = "[0-3]";
				if(choice.matches(regex)){
					int info = Integer.parseInt(choice);
					switch(info){
					case 0:
						System.out.println("------------------");
						System.out.println("您已经退出系统!");
						System.exit(1);//退出程序，返回值随便设置
						break;
					case 1:
						MaintainPage();
						break;
					case 2:
						checkAndLogPage();
						break;
					case 3:
						goodsManagementPage();
						break;
					default:
						break;
					}
				}
				System.err.println("!输入有误!");
				System.out.println("重新选择或者按0退出.");
			}while(true);
		}
		
		
		public static void MaintainPage(){
			
		}
		
		public static void checkAndLogPage(){
			
		}
		
		public static void goodsManagementPage(){
			
		}
		
		public static void shoppingSettlementPage(){
			
		}
		
		public static void salesmanManagementPage(){
			
		}
}
