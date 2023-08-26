import java.io.*;
import java.util.*;

class Solution {
	public static int solve(int[] arr, int k) {
  // your code goes here
		int st =0;
		int end =0;
		int cnt =0;
		int sum = arr[0];
		int n = arr.length;

		while(st<n && end<n){
			if(sum<k){
				//move cnt
				end++;
				if(end>=st){
					cnt += (end-st);
				}

				//add
				if(end<n)sum+=arr[end];
			}

			else{
				//remove move
				sum -= arr[st];
				st++;
			}
		}

		return cnt;
	}
}

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
	    
    	int n = sc.nextInt();
    	int[] A = new int[n];
    	for(int i=0;i<n;i++)
        A[i] = sc.nextInt();
        int B = sc.nextInt();
        Solution Obj= new Solution();
        System.out.println(Obj.solve(A, B));
	
    }
}
