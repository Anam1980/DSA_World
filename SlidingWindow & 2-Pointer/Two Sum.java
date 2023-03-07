/*Two Sum
You are given a non-decreasing array A of N integers. You are given another integer target.

You have to find two unique indices of the array such that the values at those indices have a sum equal to target.

Return the indices as a sorted integer array of size 2.

It is guaranteed that the test cases are made such that only one solution exists*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int[] twoSum(int[] arr, int target) {
		int[]ans=new int[2];
       int i=0;
		int j=arr.length-1;
		while(i<j){
			int sum=arr[i]+arr[j];
			if(sum<target){
				i++;
			}
			else if(sum>target){
				j--;
			}
			else{
				ans[0]=i+1;
				ans[1]=j+1;
				return ans;
			}
		}
		ans[0]=-1;
		ans[1]=-1;
		return ans;
    }
	
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        int m = Integer.parseInt(br.readLine().trim());
        int[] ans = (twoSum(arr, m));
        System.out.println(ans[0] + " " + ans[1]);
	}
}
