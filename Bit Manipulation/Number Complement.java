/*Number Complement
The complement of an integer is the integer you get when you flip all the 0''''s to 1''''s and all the 1''''s to 0''''s in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num. Your task is to return its complement.*/

import java.util.Scanner;

class Solution{
public static int findComplement(int num){
	  int mask = 1;
    while (mask < num) {
        mask = (mask << 1) + 1;
    }
    return num ^ mask;
    }
}
public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	System.out.println(Solution.findComplement(num));
	sc.close();
    }
}
