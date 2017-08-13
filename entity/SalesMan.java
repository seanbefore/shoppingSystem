package entity;
//售货员实体类
public class SalesMan {
	
	private int sid;
	private String sname;
	private String spassword;
	/**
	 * 验证用户登陆
	 * @param sId,spassWord
	 */
	public SalesMan(int sid,String spassword){
		this.sid = sid;
		this.spassword = spassword;
	}
	/**
	 * 查询用户、更改用户密码
	 * @param sId,sName,sPassWord
	 */
	public SalesMan(int sid,String sname,String spassword){
		this.sid = sid;
		this.sname = sname;
		this.spassword = spassword;
	}
	/**
	 * 添加用户，用户登录
	 * @param NsNameame,sPassWord
	 */
	public SalesMan(String sname,String spassword){
		this.sname = sname;
		this.spassword = spassword;
	}
	//公共方法
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	

	
	
}
