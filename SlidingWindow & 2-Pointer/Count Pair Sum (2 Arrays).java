/*Count Pair Sum (2 Arrays)
Given two sorted arrays arr1[m] and arr2[n] of distinct elements, the task is to find all pairs from both arrays whose sum is equal to x.
The pair has an element from each array.*/

import java.io.*;
import java.util.*;



class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int arr1[] = new int[m];
        int arr2[] = new int[n];
        for (int i = 0; i < m; i++) {
            arr1[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = input.nextInt();
        }
        int x = input.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.countElements(arr1, arr2, m, n, x));
    }
}

class Solution {
    public int countElements(int[] arr1, int[] arr2, int m, int n, int x) {
		
		int i=0;
		int j=n-1;
		int cnt=0;
		
		while(i<m && j>=0){
			int sum=arr1[i]+arr2[j];
			if(sum==x){
				cnt++;
				i++;
				j--;
			}
			else if(sum>x){
				j--;
			}
			else{
				i++;
			}
		}
		return cnt;
    }
}
