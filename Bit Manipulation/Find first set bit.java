/*Find first set bit
Given an integer an N. The task is to return the position of first set bit found from the right side in the binary representation of the number.*/

import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
        
        Solution obj=new Solution();
        int ans=obj.solve(n);
        System.out.println(ans);
    }
}

class Solution{
    
    static int solve(int n)
    {
           n=(n & (-n));

		int cnt=0;
		while(n>0){
			cnt++;
			n=n>>1;
		}
       return cnt;
    }
}
