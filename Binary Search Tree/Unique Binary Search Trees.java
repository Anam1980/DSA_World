import java.util.*;
class Solution{

	 public static int rec(int min, int max) {
      if(min>max)return 1;

	 int cnt=0;
		 for(int i=min; i<=max; i++){
			 //i is my root
			 //going for left part
			 int left = rec(min, i-1);
			 //as this is only value which is smaller than i

			 //going to rigt part
			  int right = rec(i+1, max);
			 //as this is only value which is greater than i

			 cnt += (left * right);
		 }

		 return cnt;
    
    }
    public static long numTrees(int n) {
       return rec(1, n);
    
    }
}
class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Solution.numTrees(n));
    }
}
