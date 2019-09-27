package leetcode;

import java.util.Arrays;

public class ArrayStrictIncreaseWithBuffer {

	public static void main(String[] args) {
		/* Input: arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
		Output: 1
		Explanation: Replace 5 with 2, then arr1 = [1, 2, 3, 6, 7].
		
		Input: arr1 = [1,5,3,6,7], arr2 = [4,3,1]
		Output: 2
		Explanation: Replace 5 with 3 and then replace 3 with 4. arr1 = [1, 3, 4, 6, 7].
		
		Input: arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
		Output: -1
		Explanation: You can't make arr1 strictly increasing.
		*/ 
//		int []arr1 = {1,5,3,6,7};
//		int []arr2 = {4,3,1};
		int []arr1 = {1,5,3,6,7};
		int []arr2 = {1,6,3,3};
		
		
		System.out.println(makeArrayIncreasing(arr1, arr2));

	}

    public static int makeArrayIncreasing(int[] arr1, int[] arr2) {
        
        //TBD: intro
        
    	int result = 0;
        int []a1 = Arrays.copyOf(arr1, arr1.length);
        int []a2 = Arrays.copyOf(arr2, arr2.length);
        //Arrays.sort(a1);
        Arrays.sort(a2);
        
        for(int i=0;i<a1.length;i++){
        	System.out.println("At i="+i);
        	if(i+1<a1.length && a1[i]<a1[i+1] && (i!=0 && a1[i-1]!=a1[i])) continue;
        	if(i==2) {
        		System.out.println("j=-1");
        		System.out.println(Arrays.toString(a1));
        	}
            for(int j=0;j<a2.length;j++){
                Arrays.sort(a2);
                if(i==0){
                    if(a2[j]!=-1 && a1[i]> a2[j]){
                        if(i+1 < a1.length){
                           if(a1[i+1]>= a2[j]){
                               int t = a1[i];
                                a1[i] = a2[j];
                                a2[j] = -1; //t;
                                result++;
                               break;
                           }
                        }else{
                            int t = a1[i];
                            a1[i] = a2[j];
                            a2[j] = -1; //t;
                            result++;
                            break;
                        }
                    }
                }else if(a2[j]!=-1 &&a1[i-1]< a2[j] && a1[i]> a2[j]){
                	if(i+1 < a1.length){
                        if(a1[i+1]>= a2[j]){
                           int t = a1[i];
                            a1[i] = a2[j];
                            a2[j] = -1; //t;
                            result++;
                            break;
                       }
                    }else{
                        int t = a1[i];
                        a1[i] = a2[j];
                        a2[j] = -1; //t;
                        result++;
                        break;
                    }
                }else {
                	//if(i==2)System.out.println("j="+j+" with a1="+a1[i]);
                }
            }
            Arrays.sort(a2);
            if((i+1 < a1.length && a1[i] == a1[i+1]) || (i!=0 && a1[i-1] == a1[i])){
            	for(int j=0;j<a2.length;j++){
            		if(i==2)System.out.println("j="+j);
            		if(i==2)System.out.println("j="+j+" with a1="+a1[i]);
            		if(a2[j]!=-1  && a1[i-1]<a2[j] && a1[i+1]> a2[j]) {
            			
                    	int t = a1[i];
                        a1[i] = a2[j];
                        a2[j] = -1; //t;
                        result++;
                        break;
            		}
            	}
            }
        }
        System.out.println(Arrays.toString(a1));
        
        if(result == 0)result = -1;
        if(!isStrict(a1)) result = -1;
        return result;
    }
    
    public static boolean isStrict(int []a1) {
    	for(int i=0;i<a1.length-1;i++) {
    		if(a1[i]>=a1[i+1]) return false;
    	}
    	
    	return true;
    }
    /*public static int makeArrayIncreasing(int[] arr1, int[] arr2) {
        
        //TBD: intro
        
        int []a1 = Arrays.copyOf(arr1, arr1.length);
        int []a2 = Arrays.copyOf(arr2, arr2.length);
        Arrays.sort(a1);
        Arrays.sort(a2);
        
        for(int i=0;i<a1.length;i++){
            
            for(int j=0;j<a2.length;j++){
                Arrays.sort(a2);
                if(i==0){
                    if(a1[i]> a2[j]){
                        if(i+1 < a1.length){
                           if(a1[i+1]> a2[j]){
                               int t = a1[i];
                                a1[i] = a2[j];
                                a2[j] = t;
                               break;
                           }
                        }else{
                            int t = a1[i];
                            a1[i] = a2[j];
                            a2[j] = t;
                            break;
                        }
                    }
                }else if(a1[i-1]< a2[j] && a1[i]> a2[j]){
                    if(i+1 < a1.length){
                        if(a1[i+1]> a2[j]){
                           int t = a1[i];
                            a1[i] = a2[j];
                            a2[j] = t;
                            break;
                       }
                    }else{
                        int t = a1[i];
                        a1[i] = a2[j];
                        a2[j] = t;
                        break;
                    }
                }
                
            }
        }
        System.out.println(Arrays.toString(a1));
        return 1;
    }*/
    
}
