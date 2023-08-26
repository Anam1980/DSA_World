import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int diffk(int[]arr,int k,int n){
		if(n<2)return 0;
		
		int i = 0; 
		int j = n-1;

		while(i<j){
			int val = Math.abs((int)(arr[i]-arr[j]));

			if(val == k)return 1;
			
			if(val<k){
				//need large
				i++;
			}
			else{
				//need less
				j--;
			}
		}
		return 0;//for false,not a case valid
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
                int n=sc.nextInt();
                int[]arr=new int[n];
                for(int i=0;i<n;i++){
                        arr[i]=sc.nextInt();
                }
                int k=sc.nextInt();
		System.out.print(diffk(arr,k,n));

	}
}
