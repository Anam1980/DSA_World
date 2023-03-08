/*Unique Number in a Triplet Array
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static int singleNumber(int[] nums) {
    int[]bits=new int[32];//to store the ith bit frequency 

	for(int n : nums){
		int i=0;//take i th bit
		while(i<32){
			if((n & 1)==1){
				bits[i]++;//increase count of bits
			}
			i++;//update i
			//right shift for next value of bit
			n = n>>1;
		}
	}

	//we have the frequency of i th bits
	int ans=0;
	int pow=1;//2^0
		for(int i=0; i<32; i++){
			//if there is multiple of 3 freq means bit is 0
			//if not multiple of 3 then bit is of 1
			if((bits[i] % 3)==1){
				ans+=pow;//add every pow 2^i of every 1 bit
			}
			pow=pow*2;
		}

		return ans;
}
}
public class Main {
  public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Solution.singleNumber(nums));
	}
}
