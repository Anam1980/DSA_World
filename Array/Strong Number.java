import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

	static boolean isPrime(int n){
		if(n<=1)return false;
		
		for(int i=2; i*i<=n; i++){
			if(n%i==0)return false;
		}

		return true;
	}
    
    public static boolean strongNumbers(long n) 
    { 
		//iterate from 2 - n
      for(int i=2; i<=n; i++){
		  //if num is prime and also divides n then is the prime factor
		  if(isPrime(i) && n%i==0){
			  //for strong number
			  if(n%(i*i)!=0){
				  return false;
			  }
		  }
	  }
	return true;
    } 
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        if(strongNumbers(n))
        System.out.println(1);
        else
        System.out.println(0);
	}
}
