/*Pair in array with difference k
You are given an array a of n integers and an integer k.

Your task is to return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length

i != j

nums[i] - nums[j] == k*/

import java.io.*;
import java.util.*;
class Main{
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
          a[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.findPairs(a,n,k));		    
    }
}

class Solution
{
    public int findPairs(int[] nums,int n, int k) {
       Arrays.sort(nums);
		int l=0;
		int r=1;
		int cnt=0;
		while(r<n){
			int diff=nums[r]-nums[l];

			if(diff==k){
				cnt++;
				l++;
				while(l<r && nums[l]==nums[l-1])l++;
				r++;
				while(r<n && nums[r]==nums[r-1])r++;
				
			}
			else if(diff>k){
				l++;
				while(l<r && nums[l]==nums[l-1])l++;
			}
			else{
				r++;
				while(r<n && nums[r]==nums[r-1])r++;
			}
			if(l==r)r++;
		}

		return cnt;
    }
}
