import java.io.File;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class TestDemo {

	public static void main(String[] args) {
		
		XStream stream = new XStream(new DomDriver()) ;
		stream.alias("ArrayOfString", Weather.class) ;
//		stream.aliasField("string", Weather.class, "loc");
////		stream.aliasField("string", Weather.class, "city");
////		stream.aliasField("string", Weather.class, "weather");
////		stream.aliasField("string", Weather.class, "sun");
////		stream.aliasField("string", Weather.class, "advise");
		stream.addImplicitCollection(Weather.class, "infos") ;
		Weather w = (Weather) stream.fromXML(new File("D:/zz.xml")) ;
System.out.println(w.infos.get(0));
System.out.println(w.infos.get(1));
System.out.println(w.infos.get(2));
System.out.println(w.infos.get(3));
System.out.println(w.infos.get(4));
		
		
 
		 
		
	}
	
	public static String toStringHex2(String s) {  
		   byte[] baKeyword = new byte[s.length() / 2];  
		   for (int i = 0; i < baKeyword.length; i++) {  
		    try {  
		     baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(  
		       i * 2, i * 2 + 2), 16));  
		    } catch (Exception e) {  
		     e.printStackTrace();  
		    }  
		   }  
		   try {  
		    s = new String(baKeyword, "utf-8");// UTF-16le:Not  
		   } catch (Exception e1) {  
		    e1.printStackTrace();  
		   }  
		   return s;  
		}  
	
	
	// 转化十六进制编码为字符串  
	public static String toStringHex1(String s) {  
	   byte[] baKeyword = new byte[s.length() / 2];  
	   for (int i = 0; i < baKeyword.length; i++) {  
	    try {  
	     baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(  
	       i * 2, i * 2 + 2), 16));  
	    } catch (Exception e) {  
	     e.printStackTrace();  
	    }  
	   }  
	   try {  
	    s = new String(baKeyword, "utf-8");// UTF-16le:Not  
	   } catch (Exception e1) {  
	    e1.printStackTrace();  
	   }  
	   return s;  
	} 
	
	public static String bytesToHexString(byte[] src){  
	    StringBuilder stringBuilder = new StringBuilder("");  
	    if (src == null || src.length <= 0) {  
	        return null;  
	    }  
	    for (int i = 0; i < src.length; i++) {  
	        int v = src[i] & 0xFF;  
	        String hv = Integer.toHexString(v);  
	        if (hv.length() < 2) {  
	            stringBuilder.append(0);  
	        }  
	        stringBuilder.append(hv);  
	    }  
	    return stringBuilder.toString();  
	}  
	/** 
	 * Convert hex string to byte[] 
	 * @param hexString the hex string 
	 * @return byte[] 
	 */  
	public static byte[] hexStringToBytes(String hexString) {  
	    if (hexString == null || hexString.equals("")) {  
	        return null;  
	    }  
	    hexString = hexString.toUpperCase();  
	    int length = hexString.length() / 2;  
	    char[] hexChars = hexString.toCharArray();  
	    byte[] d = new byte[length];  
	    for (int i = 0; i < length; i++) {  
	        int pos = i * 2;  
	        d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));  
	    }  
	    return d;  
	} 
	
	 private static byte charToByte(char c) {  
		    return (byte) "0123456789ABCDEF".indexOf(c);  
		} 
}
