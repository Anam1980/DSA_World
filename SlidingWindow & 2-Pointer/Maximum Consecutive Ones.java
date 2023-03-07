/*Maximum Consecutive Ones
Given a binary array, find count of maximum number of consecutive ones present in the array.*/

import java.io.*;
import java.util.*;

class Solution{
     public static int maxConsecutiveOnes(int[] arr, int n) {
       int itr=0;
		 int max=0;

		 for(int i=0; i<n; i++){
			 if(arr[i]==1){
				 itr++;
			 }
			 else{
				 itr=0;
			 }
			 max=Math.max(max, itr);
		 }
		 return max;
	 }
}

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.maxConsecutiveOnes(arr, n));
    }
}
