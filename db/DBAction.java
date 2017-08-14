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
			pstmt.setString(2,goods.getGprice());
			pstmt.setString(3,goods.getGnum());
			
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
			pstmt.setString(1,salesM.getGid());
			pstmt.setString(2,salesM.getSid());
			pstmt.setString(3,salesM.getSnum());
			
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
	
	
	public boolean update(int key=0,Goods goods){
		boolean b = false;
		conn = DB.getconn();
		switch(key){
			case 1:
				String sql = "UPATE GOODS SET gname=? WHERE gid=?";
				try{
					pstmt = conn.prepareStatement(sqlName);
					pstmt.setString(1, goods.getGname());
					pstmt.setInt(2,goods.getGid());
							
					int rs = pstmt.executeUpdate();
					if (rs > 0)
					{
						bool = true;
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}finally{
							DbClose.addClose(pstmt,conn);
				}
				break;
			case 2:
				String sql = "UPATE GOODS SET gprice=? WHERE gid=?";
				try{
					pstmt = conn.prepareStatement(sqlName);
					pstmt.setString(1, goods.getGprice());
					pstmt.setInt(2,goods.getGid());
							
					int rs = pstmt.executeUpdate();
					if (rs > 0)
					{
						bool = true;
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}finally{
							DbClose.addClose(pstmt,conn);
				}
				break;
			case 3:
				String sql = "UPATE GOODS SET gnum=? WHERE gid=?";
				try{
					pstmt = conn.prepareStatement(sqlName);
					pstmt.setString(1, goods.getGnum());
					pstmt.setInt(2,goods.getGid());
							
					int rs = pstmt.executeUpdate();
					if (rs > 0)
					{
						bool = true;
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}finally{
							DbClose.addClose(pstmt,conn);
				}
				break;
			default:
				break;
		}
	}
	
	public boolean update(SalesMan salesM){
		
	}
}

