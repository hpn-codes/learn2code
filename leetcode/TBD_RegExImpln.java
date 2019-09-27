package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TBD_RegExImpln {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("abc == abc " + isMatch("abc", "abc"));
		System.out.println("abc == a.c " + isMatch("abc", "a.c"));
		System.out.println("aaac == a*c " + isMatch("aaac", "a*c"));
		System.out.println("aaaccck == a*c* " + isMatch("aaac", "a*c"));
		
	}
	
	public static boolean isMatch1(String s, String p) {
	
		//trim and lower
        s = s.toLowerCase().trim();
        p = p.toLowerCase().trim();

        String meta = ".*";

      //Empty cases
        if(s.isEmpty() && p.isEmpty()) return true;
        else if(s.isEmpty() && !p.isEmpty()) return false;
        else if(!s.isEmpty() && p.isEmpty()) return false;
        
        if(p.indexOf(meta.charAt(0)) == -1 && p.indexOf(meta.charAt(1)) == -1){
        	System.out.println("No meta characters, Hence..");
            if(s.equals(p)) return true;
            else return false;
        }
        
        
        
		return false;
	}
	
	
	public static void match(String s, String p, int sIndex,int pIndex) {
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(Map.Entry<Integer, Integer> e: hm.entrySet()){
			//e.get
            
        }
		//TDB: hari - return
		
	}
	
    public static boolean isMatch(String s, String p) {
        //trim and lower
        s = s.toLowerCase().trim();
        p = p.toLowerCase().trim();
        
        String meta = ".*";
        
        //Empty cases
        if(s.isEmpty() && p.isEmpty()) return true;
        else if(s.isEmpty() && !p.isEmpty()) return false;
        else if(!s.isEmpty() && p.isEmpty()) return false;
        
        if(p.indexOf(meta.charAt(0)) == -1 && p.indexOf(meta.charAt(1)) == -1){
        	System.out.println("No meta characters, Hence..");
            if(s.equals(p)) return true;
            else return false;
        }
		

        if(p.indexOf(meta) != -1){
        	// both single and multi char replacement - DOT(.) && STAR(*) together
        	System.out.println("\n\nBoth Dot+STAR meta characters, Hence..");
            String s1 = new String(p);
            String[] sss = s1.split("\\.\\*");
            int index=0;
            for(int i=0; i< sss.length; i++) {
            	String ps = sss[i];
            	int newindex = s.indexOf(ps);
            	if(newindex > index) {
            		
            		//s1.replace(".*", s.)
            		index=newindex;
            		//
            	}else {
            		return false;
            	}
            }
            
        }
        
        if(p.indexOf(meta.charAt(0)) == -1 && p.indexOf(meta.charAt(1)) != -1){
            // only multi char replacement - STAR(*)
        	System.out.println("\n\nOnly STAR meta characters, Hence..");
            String s1 = new String(p);
            if(s1.charAt(0) == '*')return false;
            
            while (s1.indexOf('*') != -1){
                int index = p.indexOf('*');
                if(index >= s.length()) return false;
                
                char prevChar = s.charAt(index-1);
                int lastCharIndex = index;
                
                // If the char does NOT exists
                if(index-2 >=0) {
                	char prevPrevChar = s.charAt(index-2);
                	if(s.charAt(index-1) != s.charAt(index-2)) {
                    	s1 = s1.replaceFirst(new String(prevChar+"*"), new String(""));
                    	continue;
                    }
                }                
                // If the char exists only once
                System.out.println("prevChar is " +prevChar);
                if(prevChar != s.charAt(index)) {
                	System.out.println("Char found was "+s.charAt(index)+". "+prevChar + " occurs once");
                	s1 = s1.replaceFirst(new String("\\*"), new String(""));
                
                	//TBD - remove:
                	System.out.println("S1 is "+s1);
                	continue;
                }
                
                //Find how many to replace
                while(s.charAt(lastCharIndex) == '*' || prevChar == s.charAt(lastCharIndex)) {
                	lastCharIndex++;
                }lastCharIndex--;
                //if(s.charAt(lastCharIndex) == '*') lastCharIndex--;
                
                s1 = s1.replaceFirst(prevChar+"\\*", s.substring(index-1, lastCharIndex+1));        
                System.out.println("S1 is "+s1);
            }
            
            if(s.equals(s1)) return true;
            else return false;
        }

        
        if(p.indexOf(meta.charAt(0)) != -1 && p.indexOf(meta.charAt(1)) == -1){
            // only single char replacement - DOT(.)
        	System.out.println("Only DOT meta characters, Hence..");
            String s1 = new String(p);
            while (s1.indexOf('.') != -1){
                int index = p.indexOf('.');
                if(index >= s.length()) return false;
                s1 = s1.replaceFirst("\\.", new String(""+s.charAt(index)));
                System.out.println("S1 is "+s1);
            }
            if(s.equals(s1)) return true;
            else return false;
        }
        
        
        
        
        
        
        return false;
        
    }
}
