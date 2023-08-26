import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int diffk(int[]arr,int k,int n){
		int i=0;
		int j=1;
		while(i<n && j<n){
			int diff=arr[j]-arr[i];
			if(diff>k){
				i++;
			}
			else if(diff<k){
				j++;
			}
			else{
				if(i!=j)return 1;

				j++;//as mustbj >i
					
			}
			
		}
		return 0;//for false,not amy case valid
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
