package ibit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StringAnagrams {

	public static void main(String[] args) {
		
		String s = "Avani";
		List<String> l = createAnagram(s);
		System.out.println("Size ="+l.size()+" with values as "+l.toString());

	}
	
	public static ArrayList<String> createAnagram(String str){
		
		ArrayList<String> output = new ArrayList<>();
		ArrayList<Character> lst = new ArrayList<>();
		
		for(int i=0;i<str.length();i++) {
			lst.add(str.charAt(i));
		}
		
		for(int i=0;i<lst.size();i++) {
			String newStr = new String();
			ArrayList<Character> cpStk = (ArrayList<Character>) lst.clone();
			char c = (char) cpStk.remove(i);
			createAG(output, newStr, cpStk, c);
		}
		return output;
	}
	
	static void createAG(ArrayList<String> output, String str, ArrayList<Character> restOfString, char c) {
		
		str = str+c;
		if(restOfString.size() == 0) {
			output.add(str);
			return;
		}
		
		for(int i=0;i<restOfString.size();i++) {
			String newStr =  new String(str);
			ArrayList<Character> cpStk = (ArrayList<Character>) restOfString.clone();
			char nextC = (char) cpStk.remove(i);
			createAG(output, newStr, cpStk, nextC);
		}
	}

}
