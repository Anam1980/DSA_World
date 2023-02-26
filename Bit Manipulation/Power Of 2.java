/*Power of 2
Given an integer n. Your task is to return true if it is a power of two. Otherwise, return false.

Note: An integer n is a power of two, if there exists an integer x such that n == 2x.*/


import java.util.*;

class Solution{
	public static boolean isPowerOfTwo(int n) {
	
        if((n & (n-1))==0)return true;

		return false;  
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(Solution.isPowerOfTwo(n));
    }
}
