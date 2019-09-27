package leetcode;

import java.util.Arrays;

public class DuplicateInPlaceRemoval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,1,2};
		
		int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
		
		DuplicateInPlaceRemoval d = new DuplicateInPlaceRemoval();
		System.out.println(Arrays.toString(nums1));
		System.out.println(d.removeDuplicates(nums1));
		System.out.println(Arrays.toString(nums2));
		System.out.println(d.removeDuplicates(nums2));

	}
	
	public int removeDuplicates(int[] nums) {
        
        if(nums.length == 0) return 0;
        
        Boolean begin = true;
        int pos=0;// pos value is 'n'
        int currIndex=0, k = nums[0];
        for(int n: nums){
        //for(int f=0; f<nums.length;f++){ int n = nums[f];        	
            if(begin)  {
                begin = false;
                pos++;
                continue;
            }
            
            if(k == n){
                // increment pos in end
            }else if(k<n){
                if(currIndex+1 != pos){
                    nums[++currIndex] = n;
                    System.out.println(Arrays.toString(nums));
                    k=n;
                }else{
                    ++currIndex;
                }
            }
            pos++;
        }
        int n = nums[nums.length-1];
        if (k != n){
            if(currIndex+1 != pos){
                nums[++currIndex] = n;
                k=n;
            }
        }
        nums = Arrays.copyOf(nums, currIndex+1);
        return (currIndex+1);
    }
}
