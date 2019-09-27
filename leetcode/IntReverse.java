package leetcode;

/*
 * Given 32-bit signed integer, reverse digits
 * Env can only store 32-bit signed integer
 * ASSUME when reverse int overflows, returns 0 
 */
public class IntReverse {

	public static void main(String[] args) {
		int ip1=123, ip2=-123, ip3=120;
		System.out.println(printRevNum(ip1));
		System.out.println(printRevNum(ip2));
		System.out.println(printRevNum(ip3));

	}
	
	//TODO: Submit to LeetCode.. Seems efficient
	private static int printRevNum(int ip) {
		int cp = ip;
		if(cp<0) cp = Math.abs(ip);
		double upperBound = Math.log10(cp);
		if(Integer.MAX_VALUE < upperBound) return 0;
		
		StringBuffer str_ip = new StringBuffer(String.valueOf(cp));
		String str_rev = str_ip.reverse().toString();
		int rev_ip = Integer.valueOf(str_rev);
		if(ip<0) rev_ip *= -1;
		return rev_ip;
	}

}
