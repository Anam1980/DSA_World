/*Maximum width jump
A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.

Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.*/

import java.util.*;

class Solution {

    public int solve(int nums[],int n) {
        //max array
		int rmax[]=new int[n];
		rmax[n-1]=nums[n-1];
		for(int i=n-2; i>=0; i--){
			rmax[i]=Math.max(rmax[i+1], nums[i]);
		}

		int l=0;
		int r=1;

		int jump=0;
		
		while(r<n){
			if(nums[l]<=rmax[r]){
				jump=Math.max(jump, r-l);
				r++;
				
			}
			else{
				l++;		
			}
		}

		return jump;

    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
        nums[i]=sc.nextInt();

        Solution obj=new Solution();
        System.out.println(obj.solve(nums,n));
        sc.close();
    }
}
