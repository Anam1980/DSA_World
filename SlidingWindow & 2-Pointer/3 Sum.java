/*3Sum
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0. Find all unique triplets in the array which gives the sum of zero.*/

import java.io.*;
import java.util.*;



class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        //Sort all lists inside the list first
        for (int i = 0; i < result.size(); i++) {
            Collections.sort(result.get(i));
        }
        //Sort the list
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                for (int i = 0; i < l1.size(); i++) {
                    if (l1.get(i) < l2.get(i)) return -1;
                    else if (l1.get(i) > l2.get(i)) return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		
		Set<List<Integer>>anslist=new HashSet<>();	
		
		Arrays.sort(nums);
		int n=nums.length;
		for(int i=0; i<n-2; i++){
			int l=i+1;
			int r=n-1;
			
			while(l<r){
				int sum=nums[i]+nums[l]+nums[r];
				
				if(sum==0){
					ArrayList<Integer>list=new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[l]);
					list.add(nums[r]);
					anslist.add(list);
					l++;		
					r--;				
				}
				else if(sum>0){
					r--;		
				}
				else{
					l++;	
				}
			}
			
		}
		return new ArrayList<>(anslist);
    }
}
