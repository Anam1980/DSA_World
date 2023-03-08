import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static long reverse(long A) {
		//steps:
	    //find lsb
		//reverse that lsb from its postn to 32 bits
		//OR with result and reverselsb
		//shift orignal no. to right 

		long result=0;

		for(int i=0; i<32; i++){
			long lsb = A & 1l;
			long reverselsb = lsb << (31-i);

			result= result | reverselsb;

			//shift no. in right
			A = A >> 1;
			
		}
		return result;
	}
}
public class Main {
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    	long n = sc.nextLong();
			System.out.println(Solution.reverse(n));
	}
}
