package db;

import java.sql.*;
import java.util.ArrayList;

import db.DB;
import entity.*;

public final class DBAction{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public boolean add(Goods goods){
		boolean b = false;
		conn = DB.getconn();
		String sql = "INSERT INTO goods(gname,grice,gnum) VALUES(?,?,?)";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,goods.getGname());
			pstmt.setFloat(2,goods.getGprice());
			pstmt.setInt(3,goods.getGnum());
			
			int rs = pstmt.executeUpdate();
			if(rs > 0)
			{
				b = true;
			}
			
		}catch (SQLException e){
			e.printStackTrace();			
		}finally{
			DB.Close(pstmt,conn);
		}
		return b;
	}
	
	public boolean add(SalesMan salesM){
		
		boolean b = false;
		conn = DB.getconn();
		String sql = "INSERT INTO SALESMAN(sname,spassword) VALUES(?,?)";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,salesM.getSname());
			pstmt.setString(2,salesM.getSpassword());
		
			
			int rs = pstmt.executeUpdate();
			if(rs > 0)
			{
				b = true;
			}
			
		}catch (SQLException e){
			e.printStackTrace();			
		}finally{
			DB.Close(pstmt,conn);
		}
		return b;
	}

	public boolean add(GSales gsales){
		boolean b = false;
		conn = DB.getconn();
		String sql = "INSERT INTO GSALES(gid,sid,snum) VALUES(?,?,?)";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,gsales.getGid());
			pstmt.setInt(2,gsales.getSid());
			pstmt.setInt(3,gsales.getSnum());
			
			int rs = pstmt.executeUpdate();
			if(rs > 0)
			{
				b = true;
			}
			
		}catch (SQLException e){
			e.printStackTrace();			
		}finally{
			DB.Close(pstmt,conn);
		}
		return b;
	}
	
	
	public boolean update(int key ,Goods goods){
		boolean b = false;
		conn = DB.getconn();
		switch(key){
			case 1:
				String sql = "UPATE GOODS SET gname=? WHERE gid=?";
				try{
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, goods.getGname());
					pstmt.setInt(2,goods.getGid());
							
					int rs = pstmt.executeUpdate();
					if (rs > 0)
					{
						b = true;
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}finally{
							DB.Close(pstmt,conn);
				}
				break;
			case 2:
				String sql2 = "UPATE GOODS SET gprice=? WHERE gid=?";
				try{
					pstmt = conn.prepareStatement(sql2);
					pstmt.setFloat(1, goods.getGprice());
					pstmt.setInt(2,goods.getGid());
							
					int rs = pstmt.executeUpdate();
					if (rs > 0)
					{
						b = true;
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}finally{
							DB.Close(pstmt,conn);
				}
				break;
			case 3:
				String sql3 = "UPATE GOODS SET gnum=? WHERE gid=?";
				try{
					pstmt = conn.prepareStatement(sql3);
					pstmt.setInt(1, goods.getGnum());
					pstmt.setInt(2,goods.getGid());
							
					int rs = pstmt.executeUpdate();
					if (rs > 0)
					{
						b = true;
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}finally{
							DB.Close(pstmt,conn);
				}
				break;
			default:
				break;
		}
		return b;
	}
	
	public boolean update(int key,SalesMan salesM){
		boolean b = false;
		conn = DB.getconn();
		switch(key){
			case 1:
				String sql = "UPATE salesman SET sname=? WHERE sid=?";
				try{
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, salesM.getSname());
					pstmt.setInt(2,salesM.getSid());
							
					int rs = pstmt.executeUpdate();
					if (rs > 0)
					{
						b = true;
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}finally{
							DB.Close(pstmt,conn);
				}
				break;
			case 2:
				String sql2 = "UPATE salesman SET spassword=? WHERE sid=?";
				try{
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, salesM.getSpassword());
					pstmt.setInt(2,salesM.getSid());
							
					int rs = pstmt.executeUpdate();
					if (rs > 0)
					{
						b = true;
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}finally{
							DB.Close(pstmt,conn);
				}
				break;
			default:
				break;
		}
		return b;
		
	}

	public boolean deleate(int gid, Goods n){
		boolean b = false;
		conn = DB.getconn();
		String sql = "DELETE FROM goods WHERE GID=?";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,gid);
			int rs = pstmt.executeUpdate();
			if(rs > 0)
			{
				b = true;
			}
			
		}catch (SQLException e){
			e.printStackTrace();			
		}finally{
			DB.Close(pstmt,conn);
		}
		return b;
		
	}

	public boolean deleate(int sid, SalesMan n){
		boolean b = false;
		conn = DB.getconn();
		String sql = "DELETE FROM salesman WHERE SID=?";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,sid);
			int rs = pstmt.executeUpdate();
			if(rs > 0)
			{
				b = true;
			}
			
		}catch (SQLException e){
			e.printStackTrace();			
		}finally{
			DB.Close(pstmt,conn);
		}
		return b;
		
	}

	public ArrayList<Goods> queryAll(Goods n) {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DB.getconn();
		String sql = "SELECT * FROM goods";
		
		try{
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int gid = rs.getInt("gid");
				String gname = rs.getString("gname");
				float gprice = rs.getFloat("gprice");
				int gnum = rs.getShort("gnum");
				
				Goods goods=new Goods(gid, gname,gprice,gnum);
				goodsList.add(goods);
			}
			
		}catch (SQLException e){
			e.printStackTrace();			
		}finally{
			DB.Close(pstmt,conn);
		}
		return goodsList;
	}

	public ArrayList<SalesMan> queryAll(SalesMan n) {
		ArrayList<SalesMan> salesmanList = new ArrayList<SalesMan>();
		conn = DB.getconn();
		String sql = "SELECT * FROM salesman";
		
		try{
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int sid = rs.getInt("sid");
				String sname = rs.getString("sname");
				String spassword = rs.getString("spassword");
				
				SalesMan salesman=new SalesMan(sid,sname,spassword);
				salesmanList.add(salesman);
			}
			
		}catch (SQLException e){
			e.printStackTrace();			
		}finally{
			DB.Close(pstmt,conn);
		}
		return salesmanList;
	}
	
	public ArrayList<Goods> query(int key,Goods goods) {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DB.getconn();
		switch (key) {
		case 1:
			String sql = "SELECT * FROM goods WHERE gid=?";
			try{
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, goods.getGid());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					int gid = rs.getInt("gid");
					String gname = rs.getString("gname");
					float gprice = rs.getFloat("gprice");
					int gnum = rs.getInt("gnum");
					
					Goods good=new Goods(gid, gname,gprice,gnum);
					goodsList.add(good);
				}
			}catch (SQLException e){
					e.printStackTrace();			
				}finally{
					DB.Close(pstmt,conn);
				}
			break;
			
		case 2:
			String sql2 = "SELECT * FROM goods WHERE gid=?";
			try{
				
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, goods.getGname());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					int gid = rs.getInt("gid");
					String gname = rs.getString("gname");
					float gprice = rs.getFloat("gprice");
					int gnum = rs.getInt("gnum");
					
					Goods good=new Goods(gid, gname,gprice,gnum);
					goodsList.add(good);
				}
			}catch (SQLException e){
					e.printStackTrace();			
				}finally{
					DB.Close(pstmt,conn);
				}
			break;
		default:
			System.out.println("wrong option key for query.");
			break;
		}		
		return goodsList;
	}
	
	public ArrayList<SalesMan> query(SalesMan salesman){
		ArrayList<SalesMan> salesManList = new ArrayList<SalesMan>();
		conn = DB.getconn();
		
		String sName = "%"+salesman.getSname()+"%";
		String sql = "SELECT * FROM salesman WHERE sname LIKE ? ";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int sid = rs.getInt("sid");
				String sname = rs.getString("sname");
				String sPassWord = rs.getString("spassword");
				
				SalesMan salesMan = new SalesMan(sid,sname,sPassWord);
				salesManList.add(salesMan);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DB.Close(pstmt, conn, rs);
		}
		return salesManList;
	}
	
	public ArrayList<SalesMan> checkLog(SalesMan salesman){
		ArrayList<SalesMan> salesmanList = new ArrayList<SalesMan>();
		conn = DB.getconn();
		String sql = "SELECT SID,SPASSWORD FROM SALESMAN WHERE SNAME=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,salesman.getSname());
			
			rs 	  = pstmt.executeQuery();
			while (rs.next())
			{
				String sPassWord = rs.getString("spassword");
				int sId = rs.getInt("sId");
				SalesMan salesMan = new SalesMan(sId,sPassWord); 
				salesmanList.add(salesMan);						
			}
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}finally
		{
			DB.Close(pstmt, conn,rs);
		}
		
		return salesmanList;
	}
	
	public ArrayList<GSales> dailyGsales() {
		ArrayList<GSales> GsalesList = new ArrayList<GSales>(); 
		conn = DB.getconn();

		//售卖时间=当前时间 trunc(sdate) =trunc(sysdate) 单位：天
		//sql语句解释见files/sql/java_sql.sql
		String sql = "select gname,gprice,gnum, allSum from goods, (select gsgid as salesid,sum(snum) as allSum from gsales where trunc(sdate) =trunc(sysdate) group by gsgid) where gid = salesid"; 
		try
		{
			pstmt = conn.prepareStatement(sql);
			rs 	  = pstmt.executeQuery();
			while (rs.next())
			{
				String gName = rs.getString("gname");
				float gPrice = rs.getFloat("gprice");
				int gNum = rs.getInt("gnum");
				int allSnum = rs.getInt("allSum");
				
				GSales Gsales = new GSales(gName,gPrice,gNum,allSnum);
				GsalesList.add(Gsales);						
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
				{
					DB.Close(pstmt, conn, rs);
				}
		return GsalesList;
	}
}

