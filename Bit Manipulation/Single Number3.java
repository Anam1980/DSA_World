/*Given an integer array arr, in which exactly two elements appear only once and all the other elements appear exactly twice.
Find the two elements that appear only once. Return the two elements in ascending order.*/


import java.util.*;

class Solution {

    public int[] singleNumber3(int n, int[] nums) {
       //xor of all 
		int xorAll=0;
		for(int num : nums){
			xorAll=xorAll^num;
		}

		//bitmask
		int rshiftxor=(xorAll & -xorAll);

		//distribute 0 bit and 1 bit 
		//as xorAll contain 2 no. whose xor contain 1 and 0
		//1 no. has 0 bit and other has 1 bit
		int x=0;
		int y=0;

		//& with bitmask give 0 and 1 no. 
		for(int val : nums){
			if((val & rshiftxor)==0){
				x = x ^ val; 
			}
			else{
				y = y ^ val;
			}
		}

		int[]ans=new int[2];
		//print in sorted
		if(x < y){
			ans[0]=x;
			ans[1]=y;
		}
		else{
			ans[0]=y;
			ans[1]=x;
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj = new Solution();
        scn.close();
        int[] ans = Obj.singleNumber3(n, arr);
        System.out.print(ans[0] + " " + ans[1]);
    }
}
