package entity;
//�ۻ�Աʵ����
public class SalesMan {
	
	private int sid;
	private String sname;
	private String spassword;
	/**
	 * ��֤�û���½
	 * @param sId,spassWord
	 */
	public SalesMan(int sid,String spassword){
		this.sid = sid;
		this.spassword = spassword;
	}
	/**
	 * ��ѯ�û��������û�����
	 * @param sId,sName,sPassWord
	 */
	public SalesMan(int sid,String sname,String spassword){
		this.sid = sid;
		this.sname = sname;
		this.spassword = spassword;
	}
	/**
	 * ����û����û���¼
	 * @param NsNameame,sPassWord
	 */
	public SalesMan(String sname,String spassword){
		this.sname = sname;
		this.spassword = spassword;
	}
	//��������
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
