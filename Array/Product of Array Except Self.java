/*Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 */

class Solution {
    public int[] productExceptSelf(int[] a) {
			int n=a.length;
      int[]leftprefix=new int[n];
	  leftprefix[0]=1;

	  int[]rightprefix=new int[n];
	  rightprefix[n-1]=1;
	  
	  for(int i=1; i<n; i++){
		  leftprefix[i]=leftprefix[i-1]*a[i-1];
	  }

	   
	  for(int i=n-2; i>=0; i--){
		  rightprefix[i]=rightprefix[i+1]*a[i+1];
	  }

	   int[]ans=new int[n];
	  
	  for(int i=0; i<n; i++){
		  ans[i]=leftprefix[i]*rightprefix[i];
	  }
	  
	  return ans;

        
    }
}
