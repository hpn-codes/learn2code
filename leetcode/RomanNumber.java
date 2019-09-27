package leetcode;

/*
	I	1
	V	5
	X	10
	L	50
	C	100
	D	500
	M	1000
	S, _V	5000
	R, _X	10 000
	P, _L	50 000
	Q, _C	100 000
	O, _D	500 000
	N, _M	1 000 000
 */
public class RomanNumber {

	public static void main(String[] args) {
		
		System.out.println("90 :"+findRoman(90));
		System.out.println("99 :"+findRoman(99));
		System.out.println("190 :"+findRoman(190));
		System.out.println("449 :"+findRoman(449));
		System.out.println("4500 :"+findRoman(4500));
		System.out.println("4998 :"+findRoman(4998));
		System.out.println("4999 :"+findRoman(4999));
	}			

	static String findRoman(int ip) {
		int cp = ip;
		
		String[] roman = {"I","V", "X","L","C","D","M"};
		int[] rvalue = {1,5,10,50,100,500,1000};
		String[] subroman  = {"I","X","C","M"};
		int[] subrvalue = {1,10,100,1000};
		int maxi = 4999; //MMMMCMXCIX
		
		
		int i =  rvalue.length-1;
		int subi= subrvalue.length-1;
		String res = "";
		while(cp>0 && i>=0) {
			if(subi>=0 && rvalue[i]<=subrvalue[subi]) {
				subi--;
				//System.out.println("Lowering sub to "+subrvalue[subi]); 
				continue;
			}
			if(cp>maxi) return null;
			if(cp >= rvalue[i]) {
				res += roman[i];
				cp -= rvalue[i];
				//System.out.print("ADDING: ");
			}else if(i>=0 && subi>=0 && cp >= rvalue[i]-subrvalue[subi]) {
				res += subroman[subi]+roman[i];
				cp -= (rvalue[i]-subrvalue[subi]);
				//System.out.print("ADDING: ");
			}else {
				i--;
				//System.out.println("Lowering from: "+roman[i]+"; rvalue[i],subrvalue[subi]"+rvalue[i]+","+subrvalue[subi]);
			}
			//System.out.println(res);
		}
		//TODO: write the functions
	
		return res;
	}
}
