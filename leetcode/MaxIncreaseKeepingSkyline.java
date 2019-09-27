package leetcode;

import java.util.Arrays;

public class MaxIncreaseKeepingSkyline {
	    public int maxIncreaseKeepingSkyline(int[][] grid) {
	        displayGrid(grid);
	        int top[] = new int[grid.length];
	        int left[] = new int[grid.length];
	        int oldsum =0,  newsum=0;
	        
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[i].length;j++){
	                //left[i] = (left[i]<grid[i][j])?grid[i][j]:left[i];
	                //top[j] = (top[j]<grid[i][j])?grid[i][j]:top[j];
	                left[i] = max(left[i], grid[i][j]);
	                top[j] =  max(top[j],  grid[i][j]);
	                oldsum += grid[i][j];
	            }        
	        }
	        System.out.println(Arrays.toString(top));
	        System.out.println(Arrays.toString(left));
	        
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[i].length;j++){
	                grid[i][j] = min(left[i], top[j]);
	                newsum += grid[i][j];
	            }        
	        }
	        displayGrid(grid);
	        return newsum-oldsum;
	    }
	    public int max(int x, int y){       
	        if(x>y) return x;
	        return y;
	    }

	    public int min(int x, int y){       
	        if(x<y) return x;
	        return y;
	    }
	    public void displayGrid(int[][] grid){
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[i].length;j++){
	                System.out.print(grid[i][j]+" ");
	            }
	            System.out.println();
	        }
	    }

	    public static int[] stringToIntegerArray(String input) {
	        input = input.trim();
	        input = input.substring(1, input.length() - 1);
	        if (input.length() == 0) {
	          return new int[0];
	        }
	    
	        String[] parts = input.split(",");
	        int[] output = new int[parts.length];
	        for(int index = 0; index < parts.length; index++) {
	            String part = parts[index].trim();
	            output[index] = Integer.parseInt(part);
	        }
	        return output;
	    }
	    
	    
	    public static void main(String[] args) {
	    	
	    	int a [][] = 
	    	{{3, 0, 8, 4},
	    	{2, 4, 5, 7},
	    	{9, 2, 6, 3},
	    	{0, 3, 1, 0}
	    	};
	    	
	    	MaxIncreaseKeepingSkyline m = new MaxIncreaseKeepingSkyline();
	    	System.out.println("Max Increase is "+ m.maxIncreaseKeepingSkyline(a));
	    	
	    }
	}