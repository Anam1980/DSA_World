/*GAME OF XOR
Given an array arr[] of size n. The value of an array is denoted by the bit-wise XOR of all elements it contains.
Find the bit-wise XOR of the values of all subarrays of arr.*/

import java.util.*;
class Solution
{
       static int xorSubarrayXors(int arr[], int n) {
        int ans=0;
		   for(int i=0; i<n; i++){
			   int st=(i+1);
			   int end=(n-i);

			   int freq=st * end;

			   if((freq & 1)==1){//if odd then take 
				   //if even so neglect
				   ans ^= arr[i];
			   }
		   }
		   return ans;
    }
}
public class Main {

    

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int ans = Solution.xorSubarrayXors(arr, n);
        System.out.print(ans);
        input.close();
    }
}
