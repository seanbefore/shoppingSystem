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
}

