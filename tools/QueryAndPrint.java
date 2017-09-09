package tools;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import entity.Goods;
import entity.SalesMan;

public class QueryAndPrint {
	Connection        conn  = null;
	PreparedStatement pstmt = null;
	ResultSet 		rs 	 	 = null;
	
	public static int query(String oper){
		
	
		return 0;
		
	}
	public static int querySettlement(){
		return 0;
		
	}
	public ArrayList<Goods> queryGoodsKey(int gId,String gName){
		return null;
		
	}
	
	public ArrayList<SalesMan> querySalesMan(String sName){
		return null;
		
	}
}
