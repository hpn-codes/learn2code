package leetcode;

import java.util.ArrayList;

/* 
 * find longest prefix, if NOT result is '' 
 */
public class LongestPrefix {

	public static void main(String[] args) {
		ArrayList<String> lst = new ArrayList<>();
		lst.add("flower");
		lst.add("flowless");
		lst.add("f");
//		lst.add("x");
		
		System.out.print("Prefix:"+findCommonPrefix(lst));

	}

	private static String findCommonPrefix(ArrayList<String> lst) {
		if(lst.size() == 0) return "";
		if(lst.size() == 1) return lst.get(0);
		
		String str1 = lst.get(0), str2 = lst.get(1);
		
		String maxprefix = new String();
		int i = -1;
		while(i < str1.length()-1 && i < str2.length()-1 ) {
			if(str1.charAt(i+1) == str2.charAt(i+1) ) {
				i++;
			}else break;
		};
		maxprefix = str1.substring(0, i+1);
		System.out.println("max:"+maxprefix);
		
		for(String s:lst) {
			String prefix = new String(maxprefix);
			while(!s.startsWith(prefix)) {
				prefix =  prefix.substring(0, prefix.length()-1);
			}
			maxprefix = prefix;
		}
		return maxprefix;
	}

}
