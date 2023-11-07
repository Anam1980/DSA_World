import java.util.*;
import java.io.*;

class Main{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
        int N = sc.nextInt();
        Solution obj = new Solution();
        obj.toBinary(N);
        System.out.println();
    
	}
}

class Solution{
	void toBinary(int N) {
        String st = new String();
		while(N!=0){
            st+=N%2;
            N = N/2;
        }

        int i = st.length()-1;
        while(i>=0){
            System.out.print(st.charAt(i));
            i--;
        }
	}
}
