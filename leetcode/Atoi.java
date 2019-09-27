package leetcode;

public class Atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "1234";
		myAtoi("1234");
		myAtoi("  -43");
		

	}
	
	public static int myAtoi(String str) {
        str = str.trim();
        
        char[] chars= str.toCharArray();
        int i = 0;
        
        if(null == str || str.length() == 0) return 0;
        
        while(chars.length>i && chars[i] == ' '){
            i++;
        }
        
        int start=-1;
        if(chars[i] =='+' || chars[i] =='-'){
            start = i;
        }else{
            try{
                int xx = Integer.parseInt(new Character(chars[i]).toString());
                start=i;
            }catch(Exception e){
                return 0;
            }
        }
        int end=start;
        for(int j=start+1;j<chars.length;j++){
            try{
                int xx = Integer.parseInt(new Character(chars[j]).toString());
                end = j;
                System.out.print(" ;Number is "+xx);
            }catch(Exception e){
                //TODO: nothing
                break;
            }
        }
        if(start <0) return 0;
        System.out.println("Start and end are "+start +" and "+end);
        if(chars[start] == '+' || chars[start] == '-' ){ 
            if(start == end) return 0; // Example: "  +abcd"
        }
        String intStr = str.substring(start, end+1); //Math.min(str.length()-1, end+1));
        System.out.println("Number is "+intStr);
        
        Double d = Double.parseDouble(intStr);
        if(d > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(d < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else {
            Integer Int = Integer.parseInt(intStr);
            return Int.intValue();
        }
    }

}
