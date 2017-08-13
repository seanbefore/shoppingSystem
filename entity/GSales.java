package entity;

public class GSales {
	private int gid;
	private int sid;
	private int snum;
	
	private String gname;
	private float gprice;
	private int gnum;
	private int ssum;
	
	/**
	 * 购物结算
	 * @param gId,sId,sNum
	 */
	public GSales(int gid,int sid,int snum){
		this.setGid(gid);
		this.setSid(sid);
		this.setSnum(snum);
	}
	/**
	 * 展现商品列表
	 * @param gName,gPrice,gNum,allSnum
	 */
	public GSales ( String gname,float gprice,int gnum,int ssum) {
		this.setGname(gname);
		this.setGnum(gnum);
		this.setGprice(gprice);
		this.setSsum(ssum);
	}
	// 公共方法
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public float getGprice() {
		return gprice;
	}
	public void setGprice(float gprice) {
		this.gprice = gprice;
	}
	public int getGnum() {
		return gnum;
	}
	public void setGnum(int gnum) {
		this.gnum = gnum;
	}
	public int getSsum() {
		return ssum;
	}
	public void setSsum(int ssum) {
		this.ssum = ssum;
	}
	
	
 }
