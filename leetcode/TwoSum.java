package leetcode;

import java.util.*;

/* Given array of int, return indices of two numbers such that they add up to a specific target
 * You may assume that each input would have exactly one solution, and you
 * may not use the same element twice
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		
		//Soln 1: [0,1]

		int o[];
		//easy method
		o = findTwo(nums, target);
		//fast method
		o = fasterFindTwo(nums, target);
		
		System.out.println(Arrays.toString(o));
		
	}

	private static int[] findTwo(int[] nums, int target) {
		// Easy
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]>target) continue;
			for(int k=i+1;k<nums.length;k++) {
				if((nums[i]+nums[k]) ==  target) {
					int[] out = {i, k};
					return out;
				}
			}
		}
		return null;
	}
	
	private static int[] fasterFindTwo(int[] nums, int target) {
		// Faster
		
		// Since only one output is required , we can use hash
		// complement index
		HashMap<Integer, Integer> complement = new HashMap<>();
		for(int i=0;i<nums.length-1;i++) {
			if(complement.containsKey(nums[i])) {
				int[] out = {i, complement.get(nums[i])};
				return out;
			}else {
				complement.put((target-nums[i]), i);
			}
		}
		return null;
	}
}