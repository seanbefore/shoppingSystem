package tools;

import java.util.Scanner;

//�Ӽ����϶�ȡ����

public class ScannerChoice{
	
	//��ȡ�۸�
	public static float ScannerPrice(){
		float price = (float) 0.00;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("���룬����С�������λ��");
			String p = sc.next();
			String pattern = "([1-9][0-9]*)\\.([0-9]{2}|[0]\\.([0-9]{2})";
			if ( p.matches(pattern)){
				price = Float.parseFloat(p);
				break;
			}else{
				System.out.print("�������");
				continue;
			}
		}while(true);
		return price;
	}
	
	//������
	public static int ScannerNum(){
		int num = 0;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("����������");
			String p = sc.next();
			String pattern = "[1-9][0-9]*";
			if ( p.matches(pattern)){
				num = Integer.parseInt(p);
				break;
			}else{
				System.out.print("��������");
				continue;
			}
		}while(true);
		return num ;
	}
	
	//�����ַ���
	public static String ScannerString(){
		Scanner sc = new Scanner(System.in);
		System.out.print("���룺");
		return sc.next();
	}
	
	//���벼��ֵ
	@SuppressWarnings("resource")
	public static boolean ScannerBool(){
		try{
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("�Ƿ��������-��ǰ����:(Y/N)");
			String p = sc.next();
			String py = "[yY]";
			String pn = "[nN]";
			if ( p.matches(py)){
				return true;
			}else if(p.matches(pn)){
				return false;
			}else{
				System.out.print("������������������.");
				continue;
			}
		}while(true);
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return false;
	}
}