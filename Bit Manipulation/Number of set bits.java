import java.util.*;

class Solution {
    public int setBits(int n) {
       int cnt=0;
		while(n>0){
			//if it is set then cnt
			if((n & 1)==1)cnt++;
			//shift by 1 
			n>>=1;
		}

		return cnt;
    }
}
/----------------------------BRIAN'S KERNIGHAN'S ALGO------------------------------------//
   public int setBits(int n) {
       int cnt=0;
		while(n>0){
			cnt++;

			//every right 1 removes if we & with prev 
			n=((n & (n-1)));
		}

		return cnt;
    }

public class Main {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution Obj = new Solution();
        sc.close();
        System.out.println(Obj.setBits(n));
    }
}
