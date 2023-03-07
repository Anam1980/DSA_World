/*Maximum Sum Circular Array
You are given a circular array arr of size n. Your task is to find the maximum possible sum of a non-empty subarray of arr.*/

import java.util.*;

class Solution {
    public int MaxSum(int[] arr, int n) {
       int maxSum = -100000;
		int minSum = 100000; 
		int wholeSum = 0;
		
		int currMinsum = 0;
		int currMaxsum = 0;
		
		for(int i=0; i<n; i++){
			
			int Imitself = arr[i];
			
			int currMaxTrain = currMaxsum + arr[i];

			currMaxsum = Math.max(Imitself, currMaxTrain);
			maxSum = Math.max(maxSum, currMaxsum);

			wholeSum += arr[i];

			int currMinTrain =  currMinsum + arr[i];

			currMinsum = Math.min(Imitself, currMinTrain);
			minSum = Math.min(minSum, currMinsum);		
		}

		if(wholeSum == minSum)return maxSum;//all are -ve element

		return Math.max((wholeSum-minSum), maxSum);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
	    Solution Obj = new Solution();
        int ans = Obj.MaxSum(arr, n);
        System.out.println(ans);
    }
}
