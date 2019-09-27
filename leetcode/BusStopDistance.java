package leetcode;

import java.util.Arrays;

public class BusStopDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []dist = {1,2,3,4};
		
		System.out.println("Output is"+distanceBetweenBusStops(dist, 0,3));
		
//		Arrays.copyOf(a);
	}

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int totalStops = distance.length;
        
        if(start>totalStops || destination>totalStops){
            return 0;
        }
        if(0 > start && destination > totalStops)return 0;
        
        int fwdDist = 0;
        int revDist = 0;
        if(start==destination){
            return 0;
        }
        
        if(start<=destination){
            fwdDist = findDist(distance, start, destination,true);
            System.out.println("Fwd is "+fwdDist);
            revDist = findDist(distance, start, destination,false);
            System.out.println("Rev is "+revDist);
        }else{
            fwdDist = findDist(distance, destination, start,true);
            System.out.println("Fwd is "+fwdDist);
            revDist = findDist(distance, destination, start,false);
            System.out.println("Rev is "+revDist);
        }
        
        // boolean fwdReached = false;
        // int i;
        // for(i=start; i<totalStops && i<destination;i++){
        //         fwdDist += distance[i];
        // }
        // if(i == destination){
        //     fwdReached = true;
        // }else{
        //     for(i=0;i<start;i++){
        //         fwdDist += distance[i];
        //     }
        //     fwdReached = true;
        // }
        
        // boolean revReached = false;
        // int revDist = 0;
        // for(i=destination; i<totalStops && i<start ;i++){
        //         revDist += distance[i];
        // }
        // if(i == start){
        //     revReached = true;
        // }else{
        //     for(i=0;i<destination;i++){
        //         revDist += distance[i];
        //     }
        //     revReached = true;
        // }
        
        // if(!fwdReached || !revReached ){
        //     System.out.println("Something is wrong");
        // }
        
        if(fwdDist<revDist) return fwdDist;
        else return revDist;
    }
    
    public static int findDist(int[] distance, int start,int destination,boolean isFwd){
        int totalStops = distance.length;
        
        if(isFwd){
            int fwdDist = 0;
            boolean fwdReached = false;
            int i;
            for(i=start; i<destination;i++){
                    fwdDist += distance[i];
            }
            if(i == destination){
                fwdReached = true;
            }else{
                return -1;   
            }
            
            return fwdDist;
        }else{
            boolean revReached = false;
            int i;
            int revDist = 0;
            System.out.println("Dest is"+destination);
            for(i=destination; i<totalStops;i++){
                revDist += distance[i];
                System.out.println("i value is "+distance[i]);
            }
            if(0 == start){
                revReached = true;
            }else{
                for(i=0;i<start;i++){
                    revDist += distance[i];
                }
                revReached = true;
            }
            
            return revDist;
        }
        
            
    }

}

