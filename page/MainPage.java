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
			System.out.println("\t 1.��Ʒά��\n");
			System.out.println("\t 2.ǰ̨����\n");
			System.out.println("\t 3.��Ʒ����\n");
			System.out.println("***************************");
			
			System.out.println("\n������ѡ��,���߰�0�˳�.");
			do{
				String choice=ScannerChoice.ScannerString();
				String regex = "[0-3]";
				if(choice.matches(regex)){
					int info = Integer.parseInt(choice);
					switch(info){
					case 0:
						System.out.println("------------------");
						System.out.println("���Ѿ��˳�ϵͳ!");
						System.exit(1);//�˳����򣬷���ֵ�������
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
				System.err.println("!��������!");
				System.out.println("����ѡ����߰�0�˳�.");
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
