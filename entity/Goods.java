package entity;
//商品实体类
public class Goods {
	//数据库shopdb goods表
	private int gid=-1; //表主键，-1表示不插入由数据库自动生成
	private String gname;
	private float gprice=0;
	private int gnum=0;
	
	/**
	 * 添加商品信息
	 * @param gname,gprice,gum
	 */
	public Goods(String gname,float gprice,int gnum){
		
		this.setGname(gname);
		this.setGprice(gprice);
		this.setGnum(gnum);
		
	}
	/**
	 * 展示所有商品
	 * @param gid,gname,gprice,gum
	 */
	public Goods(int gid,String gname,float gprice,int gnum){
		this.setGid(gid);
		this.setGname(gname);
		this.setGprice(gprice);
		this.setGnum(gnum);
		
	}
	
	/**
	 * 根据编号更改商品信息
	 * @param gid,gum
	 */
	public Goods(int gid,String gname){
		this.setGid(gid);
		this.setGname(gname);
	}
	
	public Goods(int gid,float gprice){
		this.setGid(gid);
		this.setGprice(gprice);
	}
	
	public Goods(int gid,int gnum){
		this.setGid(gid);
		this.setGnum(gnum);
	}
	
	//公有-get、set-方法。
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
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
}
