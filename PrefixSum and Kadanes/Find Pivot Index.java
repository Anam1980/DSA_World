/*Find Pivot Index
Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.*/

import java.util.*;

class Solution {

	
    public int pivotIndex(int[] nums) {

		int n=nums.length;
		int sum=0;
		for(int s : nums){
			sum+=s;
		}

		int r=sum;

		int l=0;
		
		for(int i=0; i<n-1; i++){
			
		    r=r-nums[i];
			
			if(l==r)return i;

			l=l+nums[i];
		}
		return -1;
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
        Solution Obj = new Solution();
        int result = Obj.pivotIndex(arr);
        System.out.println(result);
        sc.close();
    }
}
