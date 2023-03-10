/*Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 500 } and a target value N.
Find the minimum number of coins and/or notes needed to make the change for Rs N. You must return the list containing the value of coins required. */

import java.io.*;
import java.util.*;

//Tc:O(N) SC:O(N)
class Solution{
	static int[]dem=new int[]{ 1, 2, 5, 10, 20, 50, 100, 500};

     static int n=dem.length;

    public void coinChange(int num){
	//add all coins with 0 freq	
    HashMap<Integer, Integer>hm=new HashMap<>();
		for(int i=n-1; i>=0; i--){
		hm.put(dem[i], 0);
	}
	
     for(int i=n-1; i>=0; i--){
         
         //if num >= coin
		 while(num >= dem[i]){
			 //update num
			 num = num - dem[i];
             
             //put with updating frequency
			hm.put(dem[i], hm.get(dem[i])+1);
		 } 
		 
	 }
//print the all coins with their freq
    for(int i=n-1; i>=0; i--){
		 System.out.println("Number of "+dem[i]+" Rupees Notes: "+hm.get(dem[i]));
	}
		
    }
}
public class Main
{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Solution obj=new Solution();
        obj.coinChange(n);
	}
}
