package ibit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MaxYearPopulation {

	public static void main(String[] args) {
		int[][] arr =
				{
					{1904, 1985},
					{1920, 2000},
					{1950, 2030},
					{1803, 1809},
					{2000, 2080},
					{2000, 2080},
					{1920, 2000},
					{1950, 2030}
				};
		/*
		 * 1803 -  1 => 1 
		 * 1810 - -1 => 0
		 * 1904 -  1 => 1
		 * 1920 -  2 => 3
		 * 1950 -  2 => 5
		 * 1986 - -1 => 4
		 * 2000 -  2 => 6
		 * 2001 - -2 => 4
		 * 2031 - -2 => 2
		 * 2081 - -2 => 0
		 * 2 things missed -
		 *  year of death is after max birth year?
		 *  cumulative summing to get the max year.
		 *  
		 */
		
		int minMax[] = findMinMax(arr);
		if(null == minMax) System.out.println("No value");
		int year = findYearOfMax(arr, minMax[0], minMax[1]);
		System.out.println("Most populous year is"+year);
	}

	private static int findYearOfMax(int[][] arr, int min, int max) {
		
		TreeMap<Integer, Integer> hm = new TreeMap<>();
		
		for(int i=0;i<arr.length;i++) {
			int birth = arr[i][0];
			int death = arr[i][1]+1;
			
			if(hm.containsKey(birth)) {
				hm.put(birth, hm.get(birth)+1);
			}else hm.put(birth, 1);
			
			if(hm.containsKey(death)) {
				hm.put(death, hm.get(death)-1);
			}else if(death<=max) {
				hm.put(death, -1);
			}else {
				// it is definitely going to be less as there are no births here
			}
		}
		
		int cumMax = 0;
		int maxYr = 0;
		
		int currMax = 0;
		int currYr = 0;
		for(Map.Entry<Integer, Integer> mp: hm.entrySet() ) {
			currYr = mp.getKey();
			currMax += mp.getValue();
			if(cumMax < currMax) {
				maxYr = currYr;
				cumMax = currMax;
			}
		}	
		return maxYr;
	}

	private static int[] findMinMax(int[][] arr) {
		int min = arr[0][0], max = arr[0][0];
		if(arr.length<1) return null;
		for(int i=0;i<arr.length;i++) {
			if(arr[i][0] > arr[i][1]) return null;
			if(min > arr[i][0]) min = arr[i][0];
			if(max < arr[i][0]) max = arr[i][0];
		}
		
		int[] minMax ={min, max};
		return minMax;
	}

}
