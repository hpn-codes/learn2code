package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ParenthesisCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//generateParenthesis_1(3); // "((())) not geting generated"
		
		//generateParenthesis(3);
		// [((())), (()()), (())(), ()(()), ()()()]
		// ["((()))", "(()())", "(())()", "()(())", "()()()"]
		
		// 8 <- Leetcode error
		
		System.out.println(generateParenthesis_3(3).toString());
	}
	
	public static List<String> generateParenthesis_3(int n) {
		List<String> result = new ArrayList<String>();
		generateParenthesisHelper(result, n, n, 0, new char[n*2]);
		return result;
	}
		
	public static void generateParenthesisHelper(List<String> result, int leftRP, int rightRP, int index, char[] str) {
		if (leftRP < 0 || rightRP < leftRP) {
			System.out.println("IF_1: "+(index)+" -- ");
			return;
		}
			

		if (leftRP == 0 && rightRP == 0)
		{
			System.out.println("IF_2: "+(index)+" -- ");
			result.add(String.copyValueOf(str));
			return;
		}

		str[index] = '(';
		System.out.println("1: "+(index+1)+" -- "+new String(str));
		generateParenthesisHelper(result, leftRP - 1, rightRP, index + 1, str);
		System.out.println("2: "+(index+1)+" -- "+new String(str));
		
		str[index] = ')';
		System.out.println("3: "+(index+1)+" -- "+new String(str));
		generateParenthesisHelper(result, leftRP, rightRP - 1, index + 1, str);
		System.out.println("4: "+(index+1)+" -- "+new String(str));
		System.out.println(result.toString());
	}
	
	//////////////////////////////////////////////////////////////////////
	// Method 2 - works but showing timeout in Leetcode 
	//////////////////////////////////////////////////////////////////////	
	public static List<String> generateParenthesis(int n) {
		
		List<String> lst = new ArrayList<>();
		HashSet<StringBuilder> s = new HashSet<>();
		
		if(n<1)return lst;
		
        StringBuilder initialInput = new StringBuilder();
        for(int i=0;i<n;i++){
            initialInput.append("()");
        }
        s.add(initialInput);
        
        for(int i=0;i<n;i++){
        	moveRight(s, initialInput, n, i); // move ')' right
        	moveLeft (s, initialInput, n, i); // move '(' right
        }
       
        List<String> str = new ArrayList<String>();
        Iterator ss = s.iterator();
        while(ss.hasNext()) {
        	str.add(new String((StringBuilder) ss.next()));
        }
        s.clear();
        
        Set<String> sset = new HashSet<>();
        for(int i=0;i<str.size();i++) {
        	sset.add(str.get(i));
        }
        //System.out.println(sset);
        str.clear();
        
        ss = sset.iterator();
        while(ss.hasNext()) {
        	str.add((String) ss.next());
        }
        
        System.out.println(str);
		return str;
	}
	
	public static int findChar(StringBuilder sb, char c, int cPos) {
		
		int k = cPos;
		int index = 0;
		for(int i=0;i<=cPos;i++) {
			index = sb.indexOf(""+c,index);
			index++;
		}index--;
		
		return index;
	}
	
	public static int nextLeftPosForChar(StringBuilder sb, char c, int cPos) {
		// '('
		
		//int pos = findChar(sb, '(', cPos);
		int pos = findChar(sb, c, cPos);
		if(pos == -1)return -1;
		
		char oppChar;
		if(c == ')') oppChar = '(';
		else oppChar = ')';
		
		for(int i=pos-1;i>=0;i--) {
			if(sb.charAt(i) == oppChar) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static int nextRightPosForChar(StringBuilder sb, char c, int cPos) {
		// ')'
		
		//int pos = findChar(sb, ')', cPos);
		int pos = findChar(sb, c, cPos);
		if(pos == -1)return -1;
		
		char oppChar;
		if(c == ')') oppChar = '(';
		else oppChar = ')';
		
		for(int i=pos+1;i<sb.length();i++) {
			if(sb.charAt(i) == oppChar) {
				return i;
			}
		}
		
		return -1;
	}

	public static int insertCharInNextPos(Set s, StringBuilder sb, char c, int cPos) {
		//System.out.println("Entering insertCharInNextPos..");
		
		char oppChar;
		if(c == ')') oppChar = '(';
		else oppChar = ')';
				
		if(c == ')') {
			int pos = findChar(sb, c, cPos);
			int npos = nextRightPosForChar(sb, c, cPos);
			if(npos == -1 )return -1;
			
			sb.deleteCharAt(pos);
			sb.insert(npos, c);
			s.add(sb);
			//System.out.println("Char "+c+" inserted at "+(npos-1)+": "+sb);
			return npos-1;
		}else if(c == '(') {
			int pos = findChar(sb, c, cPos);
			int npos = nextLeftPosForChar(sb, c, cPos);
			if(npos == -1 )return -1;
			
			sb.deleteCharAt(pos);
			sb.insert(npos-1, c);
			s.add(sb);
			//System.out.println("Char "+c+" inserted at "+(npos-1)+": "+sb);
			return npos-1;
		}else {
			System.out.println("BIG error for char "+c);
		}
		
		System.out.println("Cannot move "+sb+ " left/right for char(pos:"+cPos+"): "+c);
		return -1;
	}
	
	public static void moveLeft(Set s, StringBuilder inp, int n, int cPos){
		// move '(' left
		//System.out.println("Move of char ( in pos "+cPos+" left: ");
		
		int same =0;
		StringBuilder sb = new StringBuilder(inp);
		if(-1 == insertCharInNextPos(s, sb, '(', cPos)) {
			same=1;
		}
		
		for(int i=cPos+same;i<n;i++){
        	moveLeft(s, sb, n, i);
		}
    }
	
	public static void moveRight(Set s, StringBuilder inp, int n, int cPos){
		// move ')' right
		//System.out.println("Move of char ) in pos "+cPos+" right: ");
		
		int same =0;
		StringBuilder sb = new StringBuilder(inp);
		if(-1 == insertCharInNextPos(s, sb, ')', cPos)) {
			same = 1;
		}
		
		for(int i=cPos+same;i<n;i++){
        	moveRight(s, sb, n, i);
		}

    }
	
	
	
	
	//////////////////////////////////////////////////////////////////////
	// Method 1
	//////////////////////////////////////////////////////////////////////
	
	public static List<String> generateParenthesis_1(int n) {
        Set<StringBuilder> s = new HashSet<>();
        
        StringBuilder initialInput = new StringBuilder();
        for(int i=0;i<n;i++){
            initialInput.append("()");
        }
        
        s.add(initialInput);
        shiftBothSides(s, initialInput, n);
        System.out.println(s.toString());

        List<String> lst= new ArrayList<>();
        Iterator<StringBuilder> iterator = s.iterator(); 
        while(iterator.hasNext()) {
			StringBuilder sb = iterator.next();
			lst.add(new String(sb));
		}
        return lst;
        // [()()()]
        //["((()))"] < - MISSING..
    }
    
    public static void shiftBothSides(Set s, StringBuilder inp, int n){
    	StringBuilder sb1 = new StringBuilder(inp);
    	for(int i=n;i>0;i--){
            shiftRight(s, sb1, n, i);
            if(i==3)System.out.println("3 is happening");
        }
        
        StringBuilder sb2 = new StringBuilder(inp);
        for(int i=1;i<=n;i++){
            shiftLeft(s, sb2, n, i);
        }
    }
    
    public static void shiftRight(Set s, StringBuilder inp, int n, int k){

        int p = k;
        int j=0;
        StringBuilder sb = new StringBuilder(inp);
        
        if(k==3)System.out.println("P is "+p+"and j is"+j);
        for(j=0;j<sb.length();j++){
            if(p == 0) {break;}
            if(sb.charAt(j) == ')') p--;
            if(p == 0) {break;}
            if(k==3)System.out.println("FOR: P is "+p+"and j is"+j+" ("+sb+")");
        }
        if(k==3)System.out.println("P is "+p+"and j is"+j);
        else System.out.println("k is not 3");
        if(p ==0 && j<sb.length()) {
        	if(j == 1) {
        		
        	}
        	if(j+2>=n*2) return;
        	sb.insert(j+2, ')');
        	sb.deleteCharAt(j);
            s.add(sb);
            //System.out.println(sb +" => "+s.toString());
            System.out.println(k+":("+j+") "+inp +"=>" + sb);
        }else {
        	return;
        }
        
        for(int i=k+1;i<=n;i++){
            shiftRight(s, sb, n, i);
        }
    }
    
    public static void shiftLeft(Set s, StringBuilder inp, int n, int k){

        int p = k;
        int j=0;
        StringBuilder sb = new StringBuilder(inp);
        
        for(j=sb.length()-1;j>0;j--){
            if(p == 0) {break;}
            if(sb.charAt(j) == '(') p--;
            if(p == 0) {break;}
        }
        if(k==1)System.out.println("P is "+p+"and j is"+j);
        if(p == 0 && j!=0 && j<sb.length()) {
        	
        	sb.insert(j-1, '(');
        	sb.deleteCharAt(j+1);
            s.add(sb);
            //System.out.println(sb +" => "+s.toString());
            System.out.println("Left - "+k+":("+j+") "+inp +"=>" + sb);
        }else {
        	return;
        }
        
        for(int i=k-1;i>0 ;i--){
        	if(k==1)System.out.println("sb is "+sb+"and k is"+k);
            shiftLeft(s, sb, n, i);
        }
    }

}
