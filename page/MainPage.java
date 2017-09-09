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
				System.out.println("\t 1.商品维护\n");
				System.out.println("\t 2.前台收银\n");
				System.out.println("\t 3.商品管理\n");
				System.out.println("***************************");
				System.out.println("\n请输入选项,或者按0退出.");
				
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
				}else{
					System.err.println("!输入有误!");
					System.out.println("重新选择或者按0退出.");
				}
				
			}while(true);
		}
		
		
		public static void MaintainPage(){
			
			boolean ifBack=false;
			do{
				System.out.println("***************************\n");
				System.out.println("\t 1.添加商品\n");
				System.out.println("\t 2.更改商品\n");
				System.out.println("\t 3.删除商品\n");
				System.out.println("\t 4.查询商品\n");
				System.out.println("\t 5.显示所有商品\n");
				System.out.println("***************************");
				
				System.out.println("\n请输入选项,或者按 0 返回上一级菜单.");
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
				System.err.println("!输入有误!");
				System.out.println("重新选择或者按0退出.");
			}while(!ifBack);
		}
		
		public static void checkAndLogPage(){
			
			boolean ifBack=false;
			do{
				System.out.println("\n*******欢迎使用商超购物管理系统*******\n");
				System.out.println("\t 1.登录系统\n");
				System.out.println("\t 2.退出\n");
				System.out.println("-----------------------------");
				System.out.println("请输入选项,或者按 0 返回上一级菜单.");
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
							System.out.println("---用户名---");
							String sName = ScannerChoice.ScannerString();
							System.out.println("---密码---");
							String sPassword = ScannerChoice.ScannerString();
							
							SalesMan salesman = new SalesMan(0, sName);
							ArrayList<SalesMan> salemanInfo = new DBAction().checkLog(salesman);
							
							if(salemanInfo == null || salemanInfo.size()==0){
								System.err.println("\t!!用户名输入有误!!\n");
								System.out.println("\n剩余登陆次数："+logChance);
							}else{
								salesman = salemanInfo.get(0);//只返回一组
								
								if(salesman.getSpassword().equals(sPassword)){
									System.out.println("\t  ---账户成功登陆---");
									shoppingSettlementPage(salesman);//
								}
								else{
									System.err.println("\t!!密码错误!!\n");
									System.out.println("\n剩余登陆次数："+logChance);
								}
							}
						}
						break;
					case 2:
						System.out.println("------------------");
						System.out.println("您已经退出系统!");
						System.exit(-1);	
						break;
					
					default:
						break;
					}
				}else{
					System.err.println("!输入有误!");
					System.out.println("重新选择或者按0退出.");
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
