package leetcode;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Stack;

public class WaterVolContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		int[] arr = {1,8,6,2,5,4,8,3,7};
		//System.out.println(maxArea(arr));
		
		System.out.println(maxArea3(arr));
		
		
	}
	public static int maxArea3(int[] height) {
	
		HashMap<Integer, HashMap<Integer, Integer>> hm = new HashMap<>();
		
		for(int i=0;i<height.length;i++) {
			hm.put(i, new HashMap<Integer, Integer>());
			for(int j=0;j<height.length;j++) {
				if(i == j) continue;
				int ival = height[i];
				int jval = height[j];
				
				if(jval >= ival) {
					HashMap<Integer, Integer> h1 = hm.get(i);
					int min = Math.min(ival, jval);
					h1.put(j, min*Math.abs(i-j));
				}
			}
		}
		
		//System.out.println(hm.toString());
		
		int maxvol = -1;
		for(int i=0;i<height.length;i++) {
			for(int j=0;j<height.length;j++) {
				HashMap<Integer, Integer> ivol = hm.get(i);
				if(ivol.containsKey(j)) {
					int jvol = ivol.get(j);
					if(jvol > maxvol) maxvol =jvol;
				}
			}
		}
		return maxvol;
	}
	
    public static int maxArea(int[] height) {
        
        if(height.length < 2) return -1;
        for(int i: height){
            if(i<0) return -1;
        }
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        
        stk.push(0);
        //push in stack if right is smaller,
        // else pop and find volume.
        
        for(int i=1;i<height.length;i++){
            int left = height[stk.peek()];
            int right = height[i];
            if(left > right) {
            	stk.push(i);
            	left = height[stk.peek()];
            	System.out.println("Lesser" +stk.toString());
            }
            else if (right == left){
            	System.out.println(stk.toString());
                left = stk.pop();
                hm.put(left, new Integer(i));
                //stk.pop();
                stk.push(i);
                left = height[stk.peek()];
                System.out.println("Same" +stk.toString());
            }
            else {
                while(!stk.empty() &&  left < right){
                	hm.put(stk.pop(), i);
                    //stk.pop();
                	if(!stk.isEmpty()) left = height[stk.peek()];
                }
                stk.push(i);
                left = height[stk.peek()];
            	System.out.println("Greater" +stk.toString());
            }
            //System.out.println("\nDone -- "+hm.toString());
        }
        
        //find volume
        Volume.h = height;
        ArrayList<Volume> v= new ArrayList<>();
        for(Entry<Integer, Integer> e: hm.entrySet()){
            v.add(new Volume(e.getKey(), e.getValue()));
        }
        
        System.out.println(Volume.maxVol(v));
        System.out.println(Volume.maxVol1(hm));
        
        return -1;
    }
}

class Volume{
	static int h[];
    int left;
    int right;
    int volume;
    Boolean done;
    
    Volume(){
        
    }
    Volume(int l, int r){
        left = l;
        right =r;
        findVolume(h);
        done = false;
    }
    
    public int getVolume(){
        return volume;
    }
    
    public String toString() {
    	return ("("+h[left]+","+h[right]+") => "+volume+"{"+left+","+right+"}");    	
    }
    static int maxVol1(HashMap<Integer, Integer> hm){
    	
    	System.out.println("\n\nBaba::: ");
    	HashMap<Integer, Integer> hvol = new HashMap<>();
    	
    	for(int l=0;l<hvol.size();l++) {
    		int r = hm.get(l);
    		int min = Math.min(hm.get(l), hm.get(r));
    		hvol.put(l, min*(r-l));
    		int newr = r;
	        int v = min*(r-l);
    		for(r=r+1;r<hvol.size();r++) {
    			if(newr>r) continue;
    			min = Math.min(hm.get(l), hm.get(r));
    	        int v1 = min*(r-l);
    	        System.out.println("Baba::: " +l+","+r+" is "+ v1+ " vs "+v); 
    	        if(v1>v) {
    	        	v = v1;
    	        	newr = r;
    	        	hm.put(l, newr);    	        	
    	        }
    		}
    		//hm.put(l, newr);
    	}
    	
    	System.out.println("2nd output: "+hm.toString());
    	return -1;
    }
    
    static int maxVol(ArrayList<Volume> v2){
        int maxvol = -1;
        int index = 0;
        for(Volume v: v2){
        	System.out.println(v.toString());
            if(maxvol<v.getVolume()) {
                maxvol = v.getVolume();
                index = v2.indexOf(v);
            }
            
            System.out.println("Final Data" + v2.toString());
        }
        return maxvol;
        
    }
    
    void findVolume(int[] h){
        int min = Math.min(h[left], h[right]);
        volume = min*(right-left);
        done = true;
    }
}