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
			
			do{
				System.out.println("***************************\n");
				System.out.println("\t 1.��Ʒά��\n");
				System.out.println("\t 2.ǰ̨����\n");
				System.out.println("\t 3.��Ʒ����\n");
				System.out.println("***************************");
				System.out.println("\n������ѡ��,���߰�0�˳�.");
				
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
				}else{
					System.err.println("!��������!");
					System.out.println("����ѡ����߰�0�˳�.");
				}
				
			}while(true);
		}
		
		
		public static void MaintainPage(){
			
			boolean ifBack=false;
			do{
				System.out.println("***************************\n");
				System.out.println("\t 1.�����Ʒ\n");
				System.out.println("\t 2.������Ʒ\n");
				System.out.println("\t 3.ɾ����Ʒ\n");
				System.out.println("\t 4.��ѯ��Ʒ\n");
				System.out.println("\t 5.��ʾ������Ʒ\n");
				System.out.println("***************************");
				
				System.out.println("\n������ѡ��,���߰� 0 ������һ���˵�.");
				String choice=ScannerChoice.ScannerString();
				String regex = "[0-5]";
				if(choice.matches(regex)){
					int info = Integer.parseInt(choice);
					switch(info){
					case 0:
						ifBack = true;
						break;
					case 1:
						GoodsPage.addGoodsPage();
						break;
					case 2:
						GoodsPage.updateGoodsPage();
						break;
					case 3:
						GoodsPage.deleteGoodsPage();
						break;
					case 4:
						GoodsPage.queryGoodsPage();
						break;
					case 5:
						GoodsPage.displayGoodsPage();
						break;
					default:
						break;
					}
				}
				System.err.println("!��������!");
				System.out.println("����ѡ����߰�0�˳�.");
			}while(!ifBack);
		}
		
		public static void checkAndLogPage(){
			
			boolean ifBack=false;
			do{
				System.out.println("\n*******��ӭʹ���̳��������ϵͳ*******\n");
				System.out.println("\t 1.��¼ϵͳ\n");
				System.out.println("\t 2.�˳�\n");
				System.out.println("-----------------------------");
				System.out.println("������ѡ��,���߰� 0 ������һ���˵�.");
				String choice=ScannerChoice.ScannerString();
				String regex = "[0-2]";
				if(choice.matches(regex)){
					int info = Integer.parseInt(choice);
					switch(info){
					case 0:
						ifBack=true;
						break;
					case 1:
						int logChance = 3;
						while(logChance-- !=0){
							System.out.println("---�û���---");
							String sName = ScannerChoice.ScannerString();
							System.out.println("---����---");
							String sPassword = ScannerChoice.ScannerString();
							
							SalesMan salesman = new SalesMan(0, sName);
							ArrayList<SalesMan> salemanInfo = new DBAction().checkLog(salesman);
							
							if(salemanInfo == null || salemanInfo.size()==0){
								System.err.println("\t!!�û�����������!!\n");
								System.out.println("\nʣ���½������"+logChance);
							}else{
								salesman = salemanInfo.get(0);//ֻ����һ��
								
								if(salesman.getSpassword().equals(sPassword)){
									System.out.println("\t  ---�˻��ɹ���½---");
									shoppingSettlementPage(salesman);//
								}
								else{
									System.err.println("\t!!�������!!\n");
									System.out.println("\nʣ���½������"+logChance);
								}
							}
						}
						break;
					case 2:
						System.out.println("------------------");
						System.out.println("���Ѿ��˳�ϵͳ!");
						System.exit(-1);	
						break;
					
					default:
						break;
					}
				}else{
					System.err.println("!��������!");
					System.out.println("����ѡ����߰�0�˳�.");
				}
				
			}while(!ifBack);
		}
		
		public static void goodsManagementPage(){
			
		}
		
		public static void shoppingSettlementPage(SalesMan salesman){
			
		}
		
		public static void salesmanManagementPage(){
			
		}
}
