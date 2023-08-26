import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    
	    	int n = sc.nextInt();
			int[] A = new int[n];
	    	for(int i=0;i<n;i++)
	        A[i] = sc.nextInt();
            
	    	Solution Obj= new Solution();
	    	
            System.out.println(Obj.findNumberOfTriangles(A));		
	}
  
}
class Solution{
	public static int findNumberOfTriangles(int[] arr) {
      // a + b > c
	  //a - c < b

		long MOD = (long)(1e9+7);
		Arrays.sort(arr);
		int ans=0;
		int n = arr.length;
		for(int i=0; i<arr.length-2; i++){
			int l = i+1;
			int r = i+2;

			while(l<n && r<n){
				if(arr[i] + arr[l] > arr[r]){
					ans += (r-l);
					r++;
					ans %= MOD;
				}
				else{
					l++;
					if(l>=r)r++;
				}
			}
		}

		return ans;
	
  }
}
