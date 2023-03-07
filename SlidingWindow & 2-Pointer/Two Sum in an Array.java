/*Two Sum in an Array
Given an integer array nums and an integer target

Find indices of the two numbers from the array such that they add up to target.

NOTE: It is always ensured that two elements add up to the given target. Return the output in increasing order.*/

import java.io.*;
import java.util.*;

class Accio{
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer>mp=new HashMap<>();

		int[]ans=new int[2];
		
		for(int i=0; i<nums.length; i++){
			int diff=target-nums[i];

			if(mp.containsKey(diff)==true){
				ans[0]=mp.get(diff);;
				ans[1]=i;
				return ans;
			}
			else{
				mp.put(nums[i], i);
			}
		}
		ans[0]=-1;
		ans[1]=-1;
		return ans;
    }
}

public class Main {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int target = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = input.nextInt();
        }
        Accio obj = new Accio();
        int[] arr = obj.twoSum(nums,target);
        System.out.print(arr[0]);
        System.out.print(' ');
        System.out.print(arr[1]);
    }
}
