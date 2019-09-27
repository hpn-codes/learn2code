package leetcode;

public class IntPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(1221));
	}
	public static boolean isPalindrome(int x) {
        Integer i = new Integer(x);
        StringBuffer sbInt = new StringBuffer(i.toString());
        StringBuffer rev = new StringBuffer(i.toString());
        rev.reverse();
        
        System.out.println(sbInt +" == "+rev);
        if(sbInt.equals(rev)){
            return true;
        }
        return false;
    }
}
