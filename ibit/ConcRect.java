package ibit;

public class ConcRect {

	/*
	 * 4 4 4 4 4 4 4 
		4 3 3 3 3 3 4 
		4 3 2 2 2 3 4 
		4 3 2 1 2 3 4 
		4 3 2 2 2 3 4 
		4 3 3 3 3 3 4 
		4 4 4 4 4 4 4 
	 */

	public static int[][] prettyPrint(int A) {
        if(A<=0) return null;
        if(A == 1) {
            int a[][] = {{1}};
            return a;
            
        }
        int arrSize = 2*(A-1)+1;
        
        int output[][] = new int[arrSize][arrSize];
        
        int curr = 0;
        for(int i=0;i<A;i++) {
        	for(int j=0;j<=i;j++) {
        		int bottom = arrSize-i-1;
        		int right  = arrSize-j-1;
        		
        		output[i][j] =(A-j);
        		output[i][right] =(A-j);
        		
        		output[bottom][j] = A-j;
        		output[bottom][right] = A-j;
        		
        		curr = A-j;
        	}
        }
        for(int i=0;i<A;i++) {
        	int val = output[i][i];
        	for(int j=i+1;j<arrSize-i;j++) {
        		//if(output[i][j]!=0) 
        		output[i][j] =val;
        		output[arrSize-i-1][j] = val;
        		
        	}
        }
		return output;
    }
	
	public static void display(int[][] a) {
		for(int i=0;i<a.length;i++) {
        	for(int j=0;j<a[i].length;j++) {
        		System.out.print(a[i][j]+" ");
        	}
        	System.out.println();
		}
	}
	public static void main(String[] args) {
		display(prettyPrint(4));
		
		display(prettyPrint(1));
	}

}
