import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
                Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
                int []arr=new int[n];
                for(int i=0;i<n;i++){
                        arr[i]=sc.nextInt();
                }
                int b=sc.nextInt();

		int zeros=0;int res=0,start=0, end=0;
            while(start<n && end<n){
				if(arr[end]==0)zeros++;
				
				while(zeros>b && start<=end){
					if(arr[start]==0)zeros--;
					start++;
				}

				res=Math.max(res, (end-start+1));

				end++;
				
			}
			
				 
		System.out.print(res);
	}
		
}
