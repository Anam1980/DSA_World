/*Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

Input Format
Input consists of 4 lines.

First line contains an integer n.

Next line contains n spaced integers that denote the array

Next line contains integer m which is the number of queries for to calculate range sum.

Next m lines contains 2 integers each which denotes left and right.

Example 1
Input

6
-2 0 3 -5 2 -1
3
0 2 
2 5
0 5
Output

1 -1 -3*/

import java.util.*;

class Solution {
        public int[] sumQuery(int[] arr, int[][] ranges) {
            int n=arr.length;
			int[]prefix=new int[n];
			prefix[0]=arr[0];

			for(int i=1; i<n; i++){
				prefix[i]=prefix[i-1]+arr[i];
			}

			int[] ans=new int[ranges.length];
			for(int i=0; i<ans.length; i++){
				int l=ranges[i][0];
				int r=ranges[i][1];

				if(l==0)
				{
					ans[i]=prefix[r];
				}
				else{
				ans[i]=prefix[r]-prefix[l-1];	
				}
			}

			return ans;
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
        int m;
        m = sc.nextInt();
        int[][] ranges = new int[m][2];
        for(int i = 0; i < m; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
        Solution Obj = new Solution();
        int[] ans = Obj.sumQuery(arr, ranges);
        for(int i =0; i< ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}
