package leetcode;

public class VowelsCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "HellO";
		vowelCnt(str1);
		
		str1 = "there is a quiet Mouse";
		vowelCnt(str1);
		

		str1 = "I am happy";
		vowelCnt(str1);
		
	}
	
	public static void vowelCnt(String s) {
		
		char[] vowels = {'a','e','i','o','u','y'};
		char[] nonChar = {' ', '.','-',';'}; 
		String str = s.toLowerCase().trim();
		int cntVowels = 0, cntConsonents=0;
		
		outer:
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			
			for(char nc: nonChar){
				if(nc == c) continue outer;
			}
			
			
			Boolean isVowel = false;
			for(char v: vowels){
				if(v == c) isVowel = true;
			}
			if(isVowel) cntVowels++; else cntConsonents++;
			
		}
		
		System.out.println("Vowels:"+ cntVowels+", Consonents:"+cntConsonents);
		return;
	}

}
