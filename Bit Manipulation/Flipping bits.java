/*Flipping bits
You will be given a list of 32 bit unsigned integers. Flip all the bits ( 1->0 and 0->1) and return the result as an unsigned integer.*/

import java.util.*;
import java.io.*;

class Solution {
    public long flipBits(long n) {
		
        long max = (1l<<32)-1 ; //1<<k

			return max^n;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        Solution solution = new Solution();
        for(int qq = 0; qq < q; qq++){
            long n = input.nextLong();
            System.out.println(solution.flipBits(n));
        }
    }
}
