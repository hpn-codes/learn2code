package leetcode;

import java.util.ArrayList;

public class CarMinRefueling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int minRefuelStops(int target, int startFuel, int[][] stations) {
	        
	        // input validation
	        // startFuel - target >= no refuel
	        // 
	        
	        int fuelAvailable = startFuel;
	        ArrayList<Integer> stationList = new ArrayList<>(); 
	        for(int station=0; station< stations.length;station++){
	            // TBD: take care of first station
	            
	            if(fuelAvailable>=target) return stationList.size();
	            
	            int nextStop = findNextFuellingStation(stations, target, station, fuelAvailable);
	            if(nextStop == -1){
	                //TBD: go back
	            }
	        }
			return stationList.size();
	        
	    }
	    
	    public int findNextFuellingStation(int[][] stations, int target, int currStation,int fuelAvailable){
	        
	        
	        for(int stat = currStation; stat<stations.length; stat++){
	            //if()
	        }
	        
	        return -1;
	    }
}
