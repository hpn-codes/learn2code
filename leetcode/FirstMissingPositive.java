package leetcode;

import java.util.TreeMap;

/*
 * Given an unsorted integer array, find the smallest missing positive integer.
 */
public class FirstMissingPositive {


	public static void main(String[] args) {

		int[] ip1 = {1,2,0};
		//Output: 3
		
		int[] ip2 = {3,4,-1,1};
		//Output: 2
		
		int[] ip3 = {7,8,9,11,12};
		//Output: 10
		
		System.out.println(firstMissingPositive(ip1));
		System.out.println(firstMissingPositive(ip2));
		System.out.println(firstMissingPositive(ip3));

	}
	
    public static int firstMissingPositive(int[] nums) {
    	
    	int min, max, sum_of_nums = 0;
    	min = max = -1;
    	
    	int a[] = nums;
    	for(int i=0;i<nums.length;i++) {
    		if(a[i]<=0) continue;
    		
    		if(min == -1) {
    			min = max = a[i];
    		}
    		if(min>a[i]) min = a[i];
    		if(max<a[i]) max = a[i];
    		//System.out.println("Min/Max is "+min+"/"+max);
    		sum_of_nums += a[i];
    	}
    	int upperMax = (max*(max+1))/2;
    	int min1 = min-1;
    	int lowerMax = (min1*(min1+1))/2;
    	int num=1;
    	if(min == 1) {
    		num = upperMax - sum_of_nums;
    	}else {
    		num = upperMax - (lowerMax+sum_of_nums);
    	}
    	
    	if(min == 1 && num == 0) num = max+1;
    	return num;
        
    }

}
