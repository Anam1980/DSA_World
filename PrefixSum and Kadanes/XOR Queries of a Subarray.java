/*XOR Queries of a Subarray
You are given an array arr of positive integers. You are also given some queries where queries[i] = [lefti, righti].

For each queryi compute the XOR of elements of the array arr from index lefti to righti (arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti]).

Return an array answer where answer[i] is the answer to the ith query.

Input Format
The first line of contains two positive integers N and Q, denoting the number of elements in the arr and the number of queries respectively.

The second line contains N space-separated integers depicting the values of an array.

The next Q lines contain two positive integers lefti and righti as described in the problem statement.*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	  public static void main(String[] args) throws Throwable {
		  Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int q = sc.nextInt();
	        int [] arr= new int[n];
	        for(int i=0;i<n;i++){
	            arr[i]=sc.nextInt();
	        }
	        int [][] queries= new int[q][2];
	        for(int i=0;i<q;i++){
	            for(int j=0;j<2;j++){
	                queries[i][j]=sc.nextInt();
	            }
	        }
	        Solution Obj= new Solution();
	        
	        int [] result = Obj.xorQueries(arr,queries);
	        for(int i=0;i<result.length;i++){
	            System.out.print(result[i]+" ");
	    }
   }
}
class Solution{
  
	 public static int[] xorQueries(int[] arr, int[][] ranges) {
	        int n=arr.length;
			int[]prefix=new int[n];
			prefix[0]=arr[0];

			for(int i=1; i<n; i++){
				prefix[i]=prefix[i-1]^arr[i];
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
				ans[i]=prefix[r]^prefix[l-1];	
				}
			}

			return ans;
    }
}
