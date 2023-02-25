/*Check whether K-th bit is set or not
Given a number N and a bit number K, check if Kth bit of N is set or not. A bit is called set if it is 1. 
Position of set bit 1 should be indexed starting with 0 from LSB side in binary representation of the number.*/

import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K=sc.nextInt();
        

        Solution obj=new Solution();
        Boolean ans=obj.solve(N,K);

        if(ans==true)
            System.out.println("YES");
        else
            System.out.println("NO");
        
    }
}

class Solution{
    
    public static Boolean solve(int n,int k)
    {
        int mask=1<<k;
		if((n & mask)>0)return true;

		return false;
    }
}
