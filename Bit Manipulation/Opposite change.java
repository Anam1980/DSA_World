/*Opposite change
Given an integer n, you have to flip the bits in the binary representation of n. Flipping means changing bit '1' -> '0' and '0' to '1'.*/

import java.util.*;
 
class Solution {
 
    public int Opposite(int n) {
        int mask=1;
		while(mask<n){
			mask=(mask<<1)+1;
		}

		return mask^n;
    }
}
 
 
public class Main {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.Opposite(n));
    }
}
