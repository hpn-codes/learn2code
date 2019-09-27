package leetcode;

/*
 * Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, compute how much water 
 * it is able to trap after raining.
 * 
 * 
 * 	
 *  	|
 *   	|
 *    	|
 *     	|                      0
 *    	|		   0  -  -  -  0  0  -  0
 *     	|____0__-__0__0__-_ 0__0__0__0__0__0__
 *     	  0	 1  0  2  1  0  1  3  2  1  2  1
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		
		int[] ip = {0,1,0,2,1,0,1,3,2,1,2,1};
		int op = 6;
		
		
		System.out.println(trap(ip));

	}
	
	public static int trap(int[] h) {
		
		int i=0;
		while(h[i] == 0) i++;
		int j = h.length-1;
		while(h[j] == 0)j--;
		
		if(i == j) return 0;
		
		int left = i++; //, right=h[i];
		int volume = 0;
		int stepVol = 0;
		int localLeft = i-1;
		while(i<j) {
			if(h[left] > h[i]) {
				while(localLeft>left && h[i]>h[localLeft]) {
					stepVol = Math.abs(h[i]-h[localLeft]);
					volume += stepVol;
					localLeft--;
				}
				if(localLeft == left) localLeft = i;
								
				System.out.println("Current volume at step "+i+" is "+stepVol);
				i++;
			}else {
				while(localLeft>left && h[i]>h[localLeft]) {
					stepVol = Math.abs(h[i]-h[localLeft]);
					volume += stepVol;
				}
				if(localLeft == left) localLeft = i;
				
				stepVol = Math.abs(h[i-1]-h[i]);
				volume += stepVol;
				System.out.println("Current volume at "+i+" is "+volume);
				stepVol = 0;
				left = i++;
			}
		}
		
		return volume;
		
	}

}
