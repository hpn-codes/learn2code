package ibit;

public class StepInfiniteGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []A = {-7, -13, -12};
		int []B = { 1, -5, -5 };
		
		coverPoints(A, B);
	}

	public static int coverPoints(int[] A, int[] B) {
        
        if(A == null || B == null) return 0;
        if(A.length != B.length) return 0;
        if(A.length <= 1) return 0;
        
        int totalSteps = 0;
        for(int i=0;i<A.length-1;i++){
            int steps = getDist(A, B, i, i+1);
            if(steps == 0){
                //TBD: is this error
            }else if(steps == -1){
                //TBD: cannot be reached
            }else{
                totalSteps +=steps;
            }
            System.out.println("TotalSteps is"+totalSteps);
        }
        
        return totalSteps;
    }
    
    public static  int getDist(int[] A,int[]  B,int i,int j){
        if(j == A.length) return -1;
        
        int steps = 0;
        boolean x_complete = false, y_complete = false;
        
        int xincrement = 0, yincrement = 0;
        //x-axis
        while(!(x_complete && y_complete)){
             // (x+1, y), 
            if(A[i]+xincrement < A[j] && B[i]+yincrement == B[j]){
                xincrement++; 
                steps++;
            }// (x - 1, y), 
            else if(A[i]+xincrement > A[j] && B[i]+yincrement == B[j]){
                xincrement--; 
                steps++;
            }
            // (x, y+1), 
            else if(A[i]+xincrement == A[j] && B[i]+yincrement < B[j]){
                yincrement++; 
                steps++;
            }// (x, y-1), 
            else if(A[i]+xincrement == A[j] && B[i]+yincrement > B[j]){
                yincrement--; 
                steps++;
            }// (x-1, y-1), 
            else if(A[i]+xincrement > A[j] && B[i]+yincrement > B[j]){
                xincrement--; yincrement--; 
                steps++;
            }// (x+1,y+1), 
            else if(A[i]+xincrement < A[j] && B[i]+yincrement < B[j]){
                xincrement++; yincrement++; 
                steps++;
            }// (x-1,y+1),
            else if(A[i]+xincrement > A[j] && B[i]+yincrement < B[j]){
                xincrement--; yincrement++; 
                steps++;
            }// (x+1,y-1) 
            else if(A[i]+xincrement < A[j] && B[i]+yincrement > B[j]){
                xincrement++; yincrement--; 
                steps++;
            }else if(A[i]+xincrement == A[j] && B[i]+yincrement == B[j]){
                x_complete = y_complete = true;
                break;
            }else{
                System.out.println("Something went wrong");
            }
            System.out.println("Stepping to ("+(A[i]+xincrement)+","+(B[i]+yincrement)+")");
        }
        
        System.out.print("Current count of steps is"+steps);
        return steps;
    }
}
