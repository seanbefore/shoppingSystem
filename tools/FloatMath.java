package tools;
import java.math.BigDecimal;

//java 提供了精确计算浮点数的方法

public class FloatMath{
	private static final int DEF_DIV_SCALE = 2;//除法暴力的小数精度
	private FloatMath(){}
	public static float add(float v1,float v2){
		
		BigDecimal b1 = new BigDecimal(Float.toString(v1));
		BigDecimal b2 = new BigDecimal(Float.toString(v2));
		
		return b1.add(b2).floatValue();
	}
	
	public static float sub(float v1,float v2){
		
		BigDecimal b1 = new BigDecimal(Float.toString(v1));
		BigDecimal b2 = new BigDecimal(Float.toString(v2));
		
		return b1.subtract(b2).floatValue();
	}
	
	public static float mul(float v1,float v2){
		
		BigDecimal b1 = new BigDecimal(Float.toString(v1));
		BigDecimal b2 = new BigDecimal(Float.toString(v2));
		
		return b1.add(b2).floatValue();
	}
	
	public static float div(float v1,float v2)
	{   
		return div(v1,v2,DEF_DIV_SCALE);   
	}
	
	public static float div(float v1,float v2,int scale){
		
		if(scale < 0){
			throw new IllegalArgumentException(
			"scale need to be greater than 0");
		}
		
		BigDecimal b1 = new BigDecimal(Float.toString(v1));
		BigDecimal b2 = new BigDecimal(Float.toString(v2));
		
		return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).floatValue();
	}
	//鍥涜垗浜斿叆
	public static float round(float v1,int scale){
		
		if(scale < 0){
			throw new IllegalArgumentException(
			"scale need to be greater than 0");
		}
		
		BigDecimal b1 = new BigDecimal(Float.toString(v1));
		BigDecimal b2 = new BigDecimal("1");
		
		return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).floatValue();
	}
}