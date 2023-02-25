//Set bit at kth position
//Given a number n and a value k. From the right, set the kth bit in the binary representation of n. 
//The position of LSB(or last bit) is 0, second last bit is 1 and so on.

import java.util.*;

class Solution {
    public int setKBit(int n, int k) {
        int mask=1<<k;

		int setBit=(n | mask);

		return setBit;
    }
}

public class Main {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        sc.close();
        System.out.println(Obj.setKBit(n, k));
    }
}
