/*4Sum
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target*/

import java.util.*;
import java.io.*;
class Solution {
   public List<List<Integer>> fourSum(int[] nums, int target) {
       int n=nums.length;
	   Arrays.sort(nums);
	   List<List<Integer>>anslist=new ArrayList<>();
	   for(int i=0; i<n; i++){
		   for(int j=i+1; j<n; j++){
			   
			   int targetSum=target - (nums[i]+nums[j]);
			   int l=j+1;
			   int r=n-1;
			   while(l<r){
				   
				   int sum=nums[l]+nums[r];
				   
				   if(sum==targetSum){
					   List<Integer>list=new ArrayList<>();
					   list.add(nums[i]);
					   list.add(nums[j]);
					   list.add(nums[l]);
					   list.add(nums[r]);
					   
					   anslist.add(list);
					   
					   l++;
					   while(l<r && nums[l]==nums[l-1])l++;
					   r--;
					   while(r>l && nums[r]==nums[r+1])r--;
				   }
				   else if(sum>targetSum){
					   r--;
					   while(r>l && nums[r]==nums[r+1])r--;
				   }
				   else{
					   l++;
					    while(l<r && nums[l]==nums[l-1])l++;
				   }
			   }
			    while(j+1<n && nums[j]==nums[j+1])j++;
		   }
		    while(i+1<n && nums[i]==nums[i+1])i++;
	   }
	   return anslist;
   }
}

public class Main
{
	    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        List<List<Integer>> res = Obj.fourSum(nums, k);

      
        for(int i= 0; i<res.size(); i++){
           Collections.sort(res.get(i));
        }

     
        Collections.sort(res, new Comparator<List<Integer>>() {
               public int compare(List<Integer> frst, List<Integer> scnd) {
                    int i=0;
                    while(frst.get(i)==scnd.get(i)) i++;
                    return frst.get(i)-scnd.get(i);
                    }
                });

        for(int i=0; i<res.size(); i++){   
            for(int j=0; j<4; j++){
                System.out.print(res.get(i).get(j) + " ");
            } 
            System.out.println("");
        }
        sc.close();
	}
}
