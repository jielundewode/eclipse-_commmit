import java.util.Random;


public class Test {

	public static void main(String[] args) {

		Random random = new Random() ;
		
		//System.out.println(Integer.parseInt("01234"));
System.out.println(random.nextInt(20) );
//System.out.println(Integer.valueOf("001234"));
		// TODO Auto-generated method stub
		String testStr = "com.testStr";

		String result = "ccdd1400153f0031303030303000000000000000000000ccdd1400153f0031303030303000000000000000000000ccdd1b001549050500000000000000000000000000000000000000000000ccdd1b001549050500000000000000000000000000000000000000000000ccdd060015310779ffccdd060015310779ffccdd060015310779ffccdd060015310779ffccdd060015310779ff";

		String cmdCode = result.substring(10, 12); // 截取命令
		if ("3F".equalsIgnoreCase(cmdCode)) {
			// if (result.length() == 32) {
			// 登录指令，开始截取
			String userName = result.substring(14);

			if(userName.contains("00")){//协议以00结束。
				int index=userName.indexOf("00");
				userName = userName.substring(0,index);
			}
			System.out.println("userName: " + userName);
			
			if(userName.length() / 2 !=0)
				userName += "0" ;//不是偶数补零
			System.out.println("userName2: " + userName);
		} 
//		else if ("31".equals(cmdCode)) {
//			String cmd = result.substring(12, 14);
//			// Log.e("cmd", cmd) ;
//			if (cmd.equalsIgnoreCase("07")) { // 欢迎光临
//				System.out.println("欢迎光临");
//			} else if (cmd.equalsIgnoreCase("09")) {// 请评价
//				System.out.println("评价");
//			} else if (cmd.equalsIgnoreCase("08")) {
//				System.out.println("提示");
//
//			}
//		} else if ("04".equals(cmdCode)) {
//			// 暂停
//			System.out.println("暂停");
//		}
	}

}
