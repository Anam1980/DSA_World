/*Product of Array Except Self
Given an array of n integers where n > 1, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].*/



import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	  public static void main(String[] args) throws Throwable {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();

	        int nums[]=new int[n];
	        for(int i = 0; i < n; i++)
	        {
	            nums[i] = sc.nextInt();
	        }
	        Solution obj = new Solution();
	        long ans[] = obj.ProductOfArrayExceptSelf(n,nums);
	        for(int i=0; i<n ; i++){
	            System.out.print(ans[i] + " ");
	        }
	    }
}
class Solution{
	
  public long[] ProductOfArrayExceptSelf(int n, int[] a){
  
	  long[]leftprefix=new long[n];
	  leftprefix[0]=1;

	  long[]rightprefix=new long[n];
	  rightprefix[n-1]=1;
	  
	  for(int i=1; i<n; i++){
		  leftprefix[i]=leftprefix[i-1]*a[i-1];
	  }

	   
	  for(int i=n-2; i>=0; i--){
		  rightprefix[i]=rightprefix[i+1]*a[i+1];
	  }

	   long[]ans=new long[n];
	  
	  
	  
	  for(int i=0; i<n; i++){
		  ans[i]=leftprefix[i]*rightprefix[i];
	  }
	  
	  return ans;
}
}
