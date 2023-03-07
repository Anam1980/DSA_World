/*Minimum Size Subarray Sum
Given an array of positive integers a and a positive integer k. Your task is to return the minimal length of a subarray whose sum is greater than or equal to k. If there is no such subarray, return 0 instead.

You have to complete findLengthOfSmallestSubarray function which consists of array a and integer k as input and you have to return the minimum integer size of subarray*/

import java.util.Scanner;

class Solution{
    static int findLengthOfSmallestSubarray(int[] a, int K) {
      int n=a.length;
		int l=0;
		int r=0;
		int min=Integer.MAX_VALUE;

		int sum=0;
		
		while(r<n){
			sum+=a[r];

			while(sum>=K){
				min=Math.min(min, r-l+1);
				sum-=a[l];
				l++;
			}
			r++;
		}
		return min;
    }
}
public class Main{ 
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
		int K = keyboard.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = keyboard.nextInt();
        }
        keyboard.close();
        System.out.println(Solution.findLengthOfSmallestSubarray(a, K));
    }
}
