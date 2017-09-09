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
			boolean ifBack=false;
			do{
				System.out.println("***************************\n");
				System.out.println("\t 1.售货员管理\n");
				System.out.println("\t 2.列出当日卖出列表\n");
				System.out.println("***************************");
				
				System.out.println("\n请输入选项,或者按 0 返回上一级菜单.");
				
				String choice=ScannerChoice.ScannerString();
				String regex = "[0-2]";
				if(choice.matches(regex)){
					int info = Integer.parseInt(choice);
					switch(info){
					case 0:
						ifBack = true;
						break;
					case 1:
						salesmanManagementPage();
						break;
					case 2:
						gSalesPage.dailySaleGoodsPage();
						break;	
					default:
						break;
					}
				}
				System.err.println("!输入有误!");
				System.out.println("重新选择或者按0退出.");
			}while(!ifBack);
		}
		
		public static void shoppingSettlementPage(SalesMan salesman){
			
			System.out.println("\n\t*******购物结算*******\n");
			do
			{
				System.out.println("按 S 开始购物结算.按 0 返回账户登录界面");
				String choNext = ScannerChoice.ScannerString();
				if ("0".equals(choNext))
				{
					break;
					
				}else if ("s".equals(choNext) || "S".equals(choNext)) 
						{
							System.out.println("\n--请输入商品关键字--");
							
							int gid = QueryAndPrint.querySettlement();//当商品件数有且只有一件时返回商品gid号，商品已售空时返回 -1. >1件时返回-2 . 查无此商品时返回-3
							
							switch (gid)
							{
							case -3:
								//无此商品,重新循环
								break;
							case -1:
								System.err.println("\t--抱歉，该商品已售空--");
								break;
								
							default:
								System.out.println("--按商品编号选择商品--");
							 		
							 	//传参gid，调用精确查询商品
							 	int shoppingGid = ScannerChoice.ScannerNum();
								
							 	ArrayList<Goods> goodsList = new QueryAndPrint().queryGoodsKey(shoppingGid,null);
								if (goodsList == null || goodsList.size() == 0)
								{
									System.err.println("\t！！查无此商品 ！！\n");
								}else 
									{
										Goods goods = goodsList.get(0);
										int gNum = goods.getGnum();	
										float gPrice = goods.getGprice(); 
										
										System.out.println("--请输入购买数量--");
										do
										{
											int choicegoodsNum = ScannerChoice.ScannerNum();//获取用户要购买的数量
											
											if (choicegoodsNum > gNum)
											{
												System.err.println("\t！！仓库储备不足！！");
												System.out.println("--请重新输入购买数量--");
											}else 
												{
													float allPrice = FloatMath.mul(choicegoodsNum, gPrice);//利用BigDecimal作乘法运算
													System.out.println("\t\t\t  购物车结算\n");
													System.out.println("\t\t商品名称\t商品单价\t购买数量\t总价\n");
													System.out.println("\t\t"+goods.getGname()+"\t"+gPrice+" $\t"+choicegoodsNum+"\t"+allPrice+" $\n");
													
													do
													{
														System.out.println("确认购买：Y/N");
														String choShopping = ScannerChoice.ScannerString(); 
														if ("y".equals(choShopping) || "Y".equals(choShopping))
														{
															System.out.println("\n总价："+allPrice+" $");
															System.out.println("\n实际缴费金额");
															
															do
															{
																float amount = ScannerChoice.ScannerPrice();
																float balance = FloatMath.sub(amount, allPrice);  //用户交钱与购买物品总价间的差额
																if (balance < 0)
																{
																	System.err.println("\t！！缴纳金额不足！！");
																	System.out.println("\n请重新输入缴纳金额($)");
																}else{																
																	
		/*	这里是购物结算操作数据库！！！！！！----------------------	  1.更改goods表数量 
		  														  2.增加sales表数量
																原商品数量gNum。 结算员Id  salesManSid */
																
																	//对sales表操作
																	GSales gSales = new GSales(goods.getGid(),salesman.getSid(),choicegoodsNum);
																	boolean insert = new DBAction().add(gSales);
																	
																	//对goods表操作
																	int goodsNewNum = gNum - choicegoodsNum; //现在goods表中该商品数量
																	Goods newGoods = new Goods(goods.getGid(),goodsNewNum);
																	boolean update = new DBAction().update(3, newGoods);
											
																		if (update && insert)
																		{
																			System.out.println("找零："+balance);
																			System.out.println("\n谢谢光临，欢迎下次惠顾");
																		}else 
																			{
																				System.err.println("！支付失败！"); //出现这个错误一定是数据库操作有问题！
																			}
																	shoppingSettlementPage(salesman);//最后跳转到到购物结算页面
	   //	结束购物结算操作数据库！！！！！！-----------------------------------
																	 }
															} while (true);	
															
														}else if ("N".equals(choShopping) || "n".equals(choShopping)) 
																{
																	shoppingSettlementPage(salesman);
																}
														System.err.println("\t！！请确认购物意向！！");
													} while (true);
												}
										} while (true);
									}					
								break;
							}
						}else
							{
								System.err.println("\t!!请输入合法字符!!\n");
							}
			} while (true);
		}
		
		public static void salesmanManagementPage(){
			boolean ifBack = false;
			do
			{
				
				System.out.println("***************************\n");
				System.out.println("\t 1.添加售货员\n");
				System.out.println("\t 2.更改售货员\n");
				System.out.println("\t 3.删除售货员\n");
				System.out.println("\t 4.查询售货员\n");
				System.out.println("\t 5.显示所有售货员\n");
				System.out.println("***************************");
				
				System.out.println("\n请输入选项,或者按 0 返回上一级菜单.");
				
				String choice = ScannerChoice.ScannerString();
				String regex  = "[0-5]";
				if (choice.matches(regex))
				{
					int info = Integer.parseInt(choice);
					switch (info)
					{
					case 0:
						ifBack = true;
						break;
					case 1:
						SalesManPage.add();
						break;
					case 2:
						SalesManPage.update();
						break;
					case 3:
						SalesManPage.delete();
						break;
					case 4:
						SalesManPage.query();
						break;
					case 5:
						SalesManPage.display();
						break;
					default:
						break;
					}
				}
				else{
					System.err.println("\t!输入有误!");
				System.out.println("重新输入或按 0 返回上一级菜单.");
				}
				
			}while(!ifBack);
		}
}
