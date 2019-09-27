package leetcode;

import java.util.List;
import java.util.ArrayList;
public class Combination2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> output = combinationSum2(candidates, target);
		System.out.println(output);

		int[] candidates2 = {2,5,2,1,2};
		target = 5;
		List<List<Integer>> output2 = combinationSum2(candidates2, target);
		System.out.println(output2);
		
	}
	
	private static List<Integer> getGoodOnes(List<Integer> l, int target) {
		if(isGoodList(l, target)) {
			//System.out.print(l.toString());
			//System.out.println("is a good list");
			return l;
		}else return null;
		
//		List good = new ArrayList<Integer>();
//		for(Integer l1: (List<Integer>)l) {
//			if(isGoodList(l1, target)) {
//				good.add(l1);
//			}
//		}
//		return good;
	}
	
	public static Boolean isGoodList(List<Integer> l, int target) {
		int sum =0;
		for(Integer i1: l) {
			sum+=i1.intValue();
		}
		if(sum == target) return true;
		return false;
		
	}

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List l1 = new ArrayList();
        
        for(int i=0;i<candidates.length;i++){
        	List<Integer> l2 = new ArrayList<>();
        	
        	if(candidates[i] > target){
//        		System.out.println(candidates[i]+" is not used at all");
        		continue;
        	}else if(candidates[i] == target){
                l2.add(target);
                l1.add(l2);
                //System.out.println("Main list has"+l1.toString());
                l2 = new ArrayList();
                continue;
            }else {
            	List<List<Integer>> l3= findSum(candidates, target, i, candidates[i]);
            	for(List x1: l3) {
            		x1.add(candidates[i]);
            	}
            	//System.out.print("For i="+i+": ");
            	//System.out.println(l3.toString());
            	
            	l1.addAll(l3);   
            }       	
        	
        }
        
        //System.out.println(l1);
        //reduce to good ones
        List f = new ArrayList<List>();
    	for(List<Integer> l: (List<List<Integer>>)l1) {
    		List<Integer> f1;
    		f1 = getGoodOnes(l, target);
    		if(f1 != null) f.add(f1);
    	}
    	
		return f;
    }


    static List<List<Integer>> findSum(int[] candidates, int target, int currIndex, int currSum){
    	List l1 = new ArrayList();
    	l1.add(new ArrayList<Integer>());
    	
    	for(int i=currIndex+1;i<candidates.length;i++) {
    		List<Integer> l2; // = new ArrayList<>();
    		
    		int newSum = currSum + candidates[i];
    		if(newSum > target) {
            	continue;
            }else if(newSum == target){
            	l2 = new ArrayList();
            	l2.add(candidates[i]);
            	l1.add(l2);
            }else { // is still smaller
            	List<List<Integer>> l3 = findSum(candidates, target, i, newSum);
            	for(List x1: l3) {
            		x1.add(candidates[i]);
            	}
            	l1.addAll(l3);            	
            }
    	}
    	
//    	System.out.print("For i="+currIndex+": ");
//    	System.out.println(l1.toString());
    	
//    	List f = new ArrayList<List>();
//    	for(List<Integer> l: (List<List>)l1) {
//    		List f1 = getGoodOnes(l, target);
//    		f.add(f1);
//    	}
    	
		return l1;
    }


}
