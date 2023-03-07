/*Maximum Contiguous Subarray Sum
Given an array, A of length n.

Your task is to find the contiguous subarray within A which has the largest sum.*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
                int n=sc.nextInt();
                int[]arr=new int[n];
                for(int i=0;i<n;i++){
                        arr[i]=sc.nextInt();
                }
                int EndSum=0;
                int maxSum=Integer.MIN_VALUE;

                //Kadens's Algorithm
                for(int i=0;i<n;i++){
                        int first=arr[i];
                        int sec=arr[i]+EndSum;
                        EndSum=Math.max(first, sec);
                        maxSum=Math.max(maxSum, EndSum);
                }
                System.out.print(maxSum);
	}
}
