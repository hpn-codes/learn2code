package leetcode;

import java.util.HashMap;
import java.util.Stack;

/*
 * Validation check for parenthesis
 */

public class ParentheisValidation {

	public static void main(String[] args) {
		String ip1 ="()";
		String ip2 = "()[] {}";
		String ip3 = "(]";
		String ip4 = "([)]";
		String ip5 = "{[]}";
		
		System.out.println(ip1+parenCheck(ip1));
		System.out.println(ip2+parenCheck(ip2));
		System.out.println(ip3+parenCheck(ip3));
		System.out.println(ip4+parenCheck(ip4));
		System.out.println(ip5+parenCheck(ip5));

	}

	private static Boolean parenCheck(String ip) {
		Stack<Character> stk = new Stack<>();
		HashMap<Character, Character> hm = new HashMap<>();
		hm.put('(', ')');
		hm.put('{', '}');
		hm.put('[', ']');
		for(int i=0;i<ip.length();i++) {
//			System.out.println(stk.toString()+" :: "+ip.charAt(i));
			if(ip.charAt(i) == '(' || ip.charAt(i) == '[' || ip.charAt(i) == '{' ) {
				stk.push(ip.charAt(i));
				continue;
			}
			if(ip.charAt(i) == ')' || ip.charAt(i) == ']' || ip.charAt(i) == '}' ) {
				char popped = stk.pop();
				if(hm.get(popped) != ip.charAt(i)) {
					return false;
				}
				continue;
			}else {
				continue;
			}
		}
//		System.out.println("Final State: "+stk.toString());
		if(stk.isEmpty()) return true;
		return false;
	}

}
