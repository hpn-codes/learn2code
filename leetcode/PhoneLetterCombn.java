package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PhoneLetterCombn {

	public static void main(String[] args) {
		// TODO Auto-HashMap<K, V>ed method stub
		System.out.println(letterCombinations("23"));

	}
	
    public static List<String> letterCombinations(String digits) {
        
        ArrayList<String> str = new ArrayList<>();
        
        if(digits.equals("")) return str;
        
        str.add("");
        for(int d=0;d<digits.length();d++){
            str = makeArr(str, Integer.parseInt(""+digits.charAt(d)));
        }
        
        return str;
    }
    
    public static ArrayList<String> makeArr(List<String> str, Integer d){
        HashMap<Integer, String> hm = new HashMap<>();
		hm.put(2, "abc"); hm.put(3, "def"); hm.put(4, "ghi");
		hm.put(5, "jkl"); hm.put(6, "mno"); hm.put(7,  "pqrs");
		hm.put(8, "tuv"); hm.put(9, "wxyz");
        
        String dchars = hm.get(d);
        
        //System.out.println("Integer "+d+" for Input: "+ str.toString());
        //System.out.println();
        
        ArrayList<String> nstr = new ArrayList<>();
        while(str.size()!=0){
            String prefix = str.remove(0);
            for(int i=0;i<dchars.length();i++){
                nstr.add(prefix+dchars.charAt(i));
            }
        }
        
        System.out.println(nstr.toString());
        return nstr;
    }

}
