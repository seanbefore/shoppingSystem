package entity;
//��Ʒʵ����
public class Goods {
	//���ݿ�shopdb goods��
	private int gid=-1; //��������-1��ʾ�����������ݿ��Զ�����
	private String gname;
	private float gprice=0;
	private int gnum=0;
	
	/**
	 * �����Ʒ��Ϣ
	 * @param gname,gprice,gum
	 */
	public Goods(String gname,float gprice,int gnum){
		
		this.setGname(gname);
		this.setGprice(gprice);
		this.setGnum(gnum);
		
	}
	/**
	 * չʾ������Ʒ
	 * @param gid,gname,gprice,gum
	 */
	public Goods(int gid,String gname,float gprice,int gnum){
		this.setGid(gid);
		this.setGname(gname);
		this.setGprice(gprice);
		this.setGnum(gnum);
		
	}
	
	/**
	 * ���ݱ�Ÿ�����Ʒ��Ϣ
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
	
	//����-get��set-������
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
