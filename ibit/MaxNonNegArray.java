package ibit;

import java.util.Arrays;

public class MaxNonNegArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {1234554321, 543211234, -543211345, -543211234};
		System.out.println(Arrays.toString(maxset(A)));
	}
	
	public static int[] maxset(int[] A) {
        
        if(A == null || A.length < 1 ) return A;
        
        int maxVal = 0;
        int maxStart = 0;
        int maxLength = 1;
        
        for(int i=0;i<A.length;i++){
            
            if(A[i] < 0) continue;
            
            int maxLocal = A[i];
            int startLocal = i;
            int lengthLocal = 1;
            //if(i==3)System.out.println("i is 3");
            for(int j=i+1;j<A.length;j++){
                if(A[j] < 0) break;
                maxLocal+=A[j];
                lengthLocal++;
            }
            if(maxVal < maxLocal){
                System.out.println("maxVal is "+maxVal+" and maxLocal is "+maxLocal);
                maxVal = maxLocal;
                maxStart = startLocal;
                maxLength = lengthLocal;
            }else if(maxVal == maxLocal){
                System.out.println("2, maxVal is "+maxVal+" and maxLocal is "+maxLocal);
                if(maxLength<lengthLocal){
                    maxLength=lengthLocal;
                    maxStart = startLocal;
                }// else already min startIndex.
            }
        }
        
        int B[] = new int[maxLength];
        if(maxLength == 1 && A[maxStart] <0 ) return new int[0];
        
        System.out.println("maxStart is "+maxStart+" and maxLength is "+maxLength);
        for(int i=0;i<maxLength;i++){
            B[i] = A[maxStart+i];
        }
        
        
        
        return B;
    }

}
