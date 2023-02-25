/*Single Number
Given an array of integers A. Every element in the array appears twice but there is one element which occurs only once. Find the single element which appears for only once.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Your task is to complete the function singleElement which receives the array A as parameter and prints the only single number present in the array.*/

//TC:O(N) SC:O(1)

import java.util.*;

class Solution {
    public void singleElement(int[]A,int n) {
        int ans=0;
		
		for(int i=0; i<n; i++){
			ans=(ans^A[i]);
		}

		System.out.print(ans);
         
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
                A[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.singleElement(A,n);
        sc.close();
    }
}
