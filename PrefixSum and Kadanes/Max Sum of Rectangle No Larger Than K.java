/*Max Sum of Rectangle No Larger Than K
Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.

It is guaranteed that there will be a rectangle with a sum no larger than k.*/


import java.util.*;

class Solution {

	int  getMaxSumK(int[] arr, int k){
		
		int res=Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++){
			int currsum=0;
			for(int j=i; j< arr.length; j++){
				currsum+=arr[j];

				if(currsum <= k){
					res = Math.max(res, currsum);
				}
			}
				
		}

		return res;
	}
    public int maxSumSubmatrix(int[][] matrix, int k) {

		int row = matrix.length;
		int col = matrix[0].length;

		int ans=Integer.MIN_VALUE;
		
		for(int left = 0; left < col; left++){
			//create array to store the sum of wach row
			int[] rowSum = new int[row];
			
			for(int right = left; right < col; right++){
				
				for(int i = 0; i < row; i++){
					
					rowSum[i] += matrix[i][right];//add the sum of each row 

				}
				ans = Math.max(ans, getMaxSumK(rowSum, k));
			}
		}

		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.maxSumSubmatrix(matrix, k));
        sc.close();
    }
}
