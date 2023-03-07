/*Car pooling
There is a car with k empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.*/

import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	   public static void main(String args[]) {
		  
		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		        int[][] trips = new int[n][3];
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < 3; j++) {
		                trips[i][j] = sc.nextInt();
		            }
		        }
		        int k = sc.nextInt();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.carPooling(trips,k));
	    }
}
class Solution{
  
    public boolean carPooling(int[][] trips, int capacity) {

		int lastdroplocation=-1;

		//find the last location where last customer drop
		//by taking wach roe which contains drop lacation at 1 index
		for(int trip[] : trips){
			
			lastdroplocation=Math.max(lastdroplocation, trip[2]);
		}

		//create array of size lastdroplacation
		int[] location=new int[lastdroplocation+1];

		//add customer at pickup point and out customer at drop lacation
		for(int trip[] : trips){
			location[trip[1]] += trip[0]; // pickup at location
			location[trip[2]] -= trip[0]; //drop at location
		}

		//check at every location car contain passenger less than capacity
		for(int i=1; i<=lastdroplocation; i++){
			
			location[i] += location[i-1];//prefix sum

			//check capacity
			if(location[i] > capacity){
				return false;
			}
			
		}
		return true;
}
}
