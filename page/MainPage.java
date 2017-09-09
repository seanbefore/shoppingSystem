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
			boolean ifBack=false;
			do{
				System.out.println("***************************\n");
				System.out.println("\t 1.�ۻ�Ա����\n");
				System.out.println("\t 2.�г����������б�\n");
				System.out.println("***************************");
				
				System.out.println("\n������ѡ��,���߰� 0 ������һ���˵�.");
				
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
				System.err.println("!��������!");
				System.out.println("����ѡ����߰�0�˳�.");
			}while(!ifBack);
		}
		
		public static void shoppingSettlementPage(SalesMan salesman){
			
			System.out.println("\n\t*******�������*******\n");
			do
			{
				System.out.println("�� S ��ʼ�������.�� 0 �����˻���¼����");
				String choNext = ScannerChoice.ScannerString();
				if ("0".equals(choNext))
				{
					break;
					
				}else if ("s".equals(choNext) || "S".equals(choNext)) 
						{
							System.out.println("\n--��������Ʒ�ؼ���--");
							
							int gid = QueryAndPrint.querySettlement();//����Ʒ��������ֻ��һ��ʱ������Ʒgid�ţ���Ʒ���ۿ�ʱ���� -1. >1��ʱ����-2 . ���޴���Ʒʱ����-3
							
							switch (gid)
							{
							case -3:
								//�޴���Ʒ,����ѭ��
								break;
							case -1:
								System.err.println("\t--��Ǹ������Ʒ���ۿ�--");
								break;
								
							default:
								System.out.println("--����Ʒ���ѡ����Ʒ--");
							 		
							 	//����gid�����þ�ȷ��ѯ��Ʒ
							 	int shoppingGid = ScannerChoice.ScannerNum();
								
							 	ArrayList<Goods> goodsList = new QueryAndPrint().queryGoodsKey(shoppingGid,null);
								if (goodsList == null || goodsList.size() == 0)
								{
									System.err.println("\t�������޴���Ʒ ����\n");
								}else 
									{
										Goods goods = goodsList.get(0);
										int gNum = goods.getGnum();	
										float gPrice = goods.getGprice(); 
										
										System.out.println("--�����빺������--");
										do
										{
											int choicegoodsNum = ScannerChoice.ScannerNum();//��ȡ�û�Ҫ���������
											
											if (choicegoodsNum > gNum)
											{
												System.err.println("\t�����ֿⴢ�����㣡��");
												System.out.println("--���������빺������--");
											}else 
												{
													float allPrice = FloatMath.mul(choicegoodsNum, gPrice);//����BigDecimal���˷�����
													System.out.println("\t\t\t  ���ﳵ����\n");
													System.out.println("\t\t��Ʒ����\t��Ʒ����\t��������\t�ܼ�\n");
													System.out.println("\t\t"+goods.getGname()+"\t"+gPrice+" $\t"+choicegoodsNum+"\t"+allPrice+" $\n");
													
													do
													{
														System.out.println("ȷ�Ϲ���Y/N");
														String choShopping = ScannerChoice.ScannerString(); 
														if ("y".equals(choShopping) || "Y".equals(choShopping))
														{
															System.out.println("\n�ܼۣ�"+allPrice+" $");
															System.out.println("\nʵ�ʽɷѽ��");
															
															do
															{
																float amount = ScannerChoice.ScannerPrice();
																float balance = FloatMath.sub(amount, allPrice);  //�û���Ǯ�빺����Ʒ�ܼۼ�Ĳ��
																if (balance < 0)
																{
																	System.err.println("\t�������ɽ��㣡��");
																	System.out.println("\n������������ɽ��($)");
																}else{																
																	
		/*	�����ǹ������������ݿ⣡����������----------------------	  1.����goods������ 
		  														  2.����sales������
																ԭ��Ʒ����gNum�� ����ԱId  salesManSid */
																
																	//��sales�����
																	GSales gSales = new GSales(goods.getGid(),salesman.getSid(),choicegoodsNum);
																	boolean insert = new DBAction().add(gSales);
																	
																	//��goods�����
																	int goodsNewNum = gNum - choicegoodsNum; //����goods���и���Ʒ����
																	Goods newGoods = new Goods(goods.getGid(),goodsNewNum);
																	boolean update = new DBAction().update(3, newGoods);
											
																		if (update && insert)
																		{
																			System.out.println("���㣺"+balance);
																			System.out.println("\nлл���٣���ӭ�´λݹ�");
																		}else 
																			{
																				System.err.println("��֧��ʧ�ܣ�"); //�����������һ�������ݿ���������⣡
																			}
																	shoppingSettlementPage(salesman);//�����ת�����������ҳ��
	   //	�����������������ݿ⣡����������-----------------------------------
																	 }
															} while (true);	
															
														}else if ("N".equals(choShopping) || "n".equals(choShopping)) 
																{
																	shoppingSettlementPage(salesman);
																}
														System.err.println("\t������ȷ�Ϲ������򣡣�");
													} while (true);
												}
										} while (true);
									}					
								break;
							}
						}else
							{
								System.err.println("\t!!������Ϸ��ַ�!!\n");
							}
			} while (true);
		}
		
		public static void salesmanManagementPage(){
			boolean ifBack = false;
			do
			{
				
				System.out.println("***************************\n");
				System.out.println("\t 1.����ۻ�Ա\n");
				System.out.println("\t 2.�����ۻ�Ա\n");
				System.out.println("\t 3.ɾ���ۻ�Ա\n");
				System.out.println("\t 4.��ѯ�ۻ�Ա\n");
				System.out.println("\t 5.��ʾ�����ۻ�Ա\n");
				System.out.println("***************************");
				
				System.out.println("\n������ѡ��,���߰� 0 ������һ���˵�.");
				
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
					System.err.println("\t!��������!");
				System.out.println("��������� 0 ������һ���˵�.");
				}
				
			}while(!ifBack);
		}
}
