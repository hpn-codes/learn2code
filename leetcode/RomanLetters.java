package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class RomanLetters {

	public static void main(String[] args) {
		System.out.println("Roman : ");
		System.out.println(intToRoman(3));
		System.out.println("Int for IV: "+romanToInt("IV"));
	}

	public static int romanToInt(String s) {
		String[] roman1 = {"M", "D", "C", "L", "X", "V", "I", "-"};
        Integer[] roVal1 = {1000, 500, 100, 50, 10, 5, 1, 0};
        
        //s= s+"-";
        ArrayList<String> roman = new ArrayList<String>(Arrays.asList(roman1));
        ArrayList<Integer> roVal = new ArrayList<Integer>(Arrays.asList(roVal1));
        
        Stack<String> stk = new Stack();
        int result=0;
        String input = new String(s);
        int index = 0;
        while(index < input.length()){
            char curr = input.charAt(index);
            char lookUp;
            
            if(index+1 >= input.length()) lookUp = '-';
            else lookUp = input.charAt(index+1);
            
            int currIndex = roman.indexOf(""+curr);
            int lookUpIndex = roman.indexOf(""+lookUp);
            
           if("-".equals(""+lookUp) || currIndex <= lookUpIndex){
                result = result+ roVal.get(currIndex);
                while(!stk.isEmpty()){
                    int val = roVal.get(roman.indexOf((String)stk.pop()));
                    result = result - val;
                }
                System.out.println("IF:At index"+index+"result is "+result);
                index++;
            }else{
                //lesser than
                stk.push(""+curr);
                System.out.println("Else:At index"+index+"result is "+result);
                index++;
            }
            System.out.println("With Lookup index"+index+"result is "+result);
        }
        return result;
    }
	
	public static String intToRoman(int num) {
        HashMap<Integer, Character> h = new HashMap<>();
        h.put(1,    'I');
        h.put(5,    'V');
        h.put(10,   'X');
        h.put(50,   'L');
        h.put(100,  'C');
        h.put(500,  'D');
        h.put(1000, 'M');
        
        if(num>3999) return "-1";
        String result = "";
        int n = num;
        
        while(n>0){
        	System.out.println("Currently n is "+n);
            if(n>=900){
                if(n>=1000){
                    result = result+h.get(1000); n-=1000; continue;
                }else{
                    result = result+h.get(100)+h.get(1000); n-=900; continue;
                }
            }
            if(n>=400){
                if(n>=500){
                    result = result+h.get(500); n-=500; continue;
                }else{
                    result = result+h.get(100)+h.get(500); n-=400; continue;
                }
            }
            if(n>=90){
                if(n>=100){
                    result = result+h.get(100); n-=100; continue;
                }else{
                    result = result+h.get(10)+h.get(100); n-=90; continue;
                }
            }
            if(n>=40){
                if(n>=50){
                    result = result+h.get(50); n-=50; continue;
                }else{
                    result = result+h.get(10)+h.get(50); n-=40; continue;
                }
            }
            if(n>=9){
                if(n>=10){
                    result = result+h.get(10); n-=10; continue;
                }else{
                    result = result+h.get(1)+h.get(10); n-=9; continue;
                }
            }
            if(n>=4){
                if(n>=5){
                    result = result+h.get(5); n-=5; continue;
                }else{
                    result = result+h.get(1)+h.get(5); n-=4; continue;
                }
            }
            if(n<=3){
                result = result+h.get(1); n--; continue;
            }
        }
        return result;
    }
}