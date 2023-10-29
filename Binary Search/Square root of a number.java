import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void sqrt(int A) {
        //sq root will be between 0 -- A
        long low = 0;
        long high = (long)A;

        long floor = 0;
        
        while(low<=high){
            long mid = (low + high)/2;

            if(mid*mid<=A){
                floor = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

       System.out.print(floor);
    }

  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  int A = sc.nextInt();
	  
    sqrt(A);
		
	}
}
