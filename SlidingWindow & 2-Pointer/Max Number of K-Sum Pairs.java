/*Max Number of K-Sum Pairs
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.*/

import java.util.*;

class Solution {
    public int maxOperations(int[] nums, int k) {
       int n=nums.length;
		int l=0;
		int r=n-1;
		int cnt=0;
		Arrays.sort(nums);
		while(l<r){
			int sum=nums[l]+nums[r];
			if(sum==k){
				cnt++;
				l++;
				r--;	
			}
			else if(sum>k){
				r--;
			}
			else{
				l++;
			}
			
		}
		return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.maxOperations(arr, k);
        System.out.println(result);
        sc.close();
    }
}
