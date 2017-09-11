package tools;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import db.DB;
import db.DBAction;
import entity.Goods;
import entity.SalesMan;

public class QueryAndPrint {
	Connection        conn  = null;
	PreparedStatement pstmt = null;
	ResultSet 		rs 	 	 = null;
	
	public static int query(String oper){
		int gid = -1;
		System.out.println("输入商品名称：");
		String shopping = ScannerChoice.ScannerString();
		ArrayList<Goods> goodsList = new QueryAndPrint().queryGoodsKey(-1, shopping);
		if (goodsList == null || goodsList.size() <= 0){
			System.err.println("\t！！查无此商品 ！！");
			boolean ifStay = ScannerChoice.ScannerBool();
			if(ifStay){
				gid = query(oper);
			}
		}else{
			Goods goods = goodsList.get(0);
			
			System.out.println("\t\t\t\t\t商品列表\n\n");
			System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注\n");
			System.out.print("\t"+goods.getGid()+"\t\t"+goods.getGname()+"\t\t"+goods.getGprice()+"\t\t"+goods.getGnum());
			if (goods.getGnum()==0)
			{
				System.out.println("\t\t该商品已售空");
			}else if (goods.getGnum()<10)
					{
						System.out.println("\t\t该商品已不足10件");
					}else 
						{
							System.out.println("\t\t-");
						}
			gid = goods.getGid(); //将商品编号返回给调用者
		}
		return gid;
		
	}
	public static int querySettlement(){
		int gid = -1;
		String gname = ScannerChoice.ScannerString();
		Goods goods= new Goods(-1, gname);
		ArrayList<Goods> goodsSettlement = new DBAction().query(2, goods);//調用 关键字查询函数
	    if (goodsSettlement == null || goodsSettlement.size() <= 0)
		{
				System.err.println("\t！！查无此商品 ！！\n");
				gid = -3;	
		}else	//查到有此商品，实现进行 更改商品 信息操作！
			{	
				System.out.println("\t\t\t\t\t商品列表\n\n");
				System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注\n");
				for (int i = 0; i < goodsSettlement.size(); i++)
				{
					Goods goodsList = goodsSettlement.get(i);
					if (goods.getGnum() > 0)
					{
						System.out.print("\t"+goods.getGid()+"\t\t"+goods.getGname()+"\t\t"+goods.getGprice()+"\t\t"+goods.getGnum());
							
						if (goods.getGnum()==0)
						{
							System.out.println("\t\t该商品已售空");
						}else if (goods.getGnum()<10)
								{
									System.out.println("\t\t该商品已不足10件");
								}else 
									{
										System.out.println("\t\t-");
									}
							if (goodsSettlement.size()==1)
							{
								gid = goods.getGid(); //将商品编号返回给调用者
							}else 
								{
									gid = -2;
								}
					}
				}
			}
	 return gid; 
		
	}
	public ArrayList<Goods> queryGoodsKey(int gId,String gName){
		
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DB.getconn();
		
		String sql = "SELECT * FROM GOODS WHERE GID=? OR GNAME=? ";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gId);
			pstmt.setString(2, gName);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int gid = rs.getInt("gid");
				String gname = rs.getString(2);
				float gprice = rs.getFloat(3);
				int gnum = rs.getInt(4);
				
				Goods goods = new Goods(gid,gname,gprice,gnum);
				goodsList.add(goods);
			}
		}catch(SQLException e){
			
			e.printStackTrace();
		}finally {
			DB.Close(pstmt, conn, rs);
		}
		
		return goodsList;
		
	}
	
	public ArrayList<SalesMan> querySalesMan(String sName){
		ArrayList<SalesMan> salesmanList = new ArrayList<SalesMan>();
		conn = DB.getconn();
		String sql = "SELECT * FROM SALESMAN WHERE SNAME=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			rs=pstmt.executeQuery();
			while(rs.next()){
				int sid = rs.getInt("sid");
				String sname = rs.getString(2);
				String sPassWord = rs.getString(3);
				
				SalesMan salesMan = new SalesMan(sid,sname,sPassWord);
				salesmanList.add(salesMan);
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally {
			DB.Close(pstmt, conn, rs);
		}
		return null;
		
	}
}
