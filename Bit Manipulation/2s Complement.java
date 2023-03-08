/*2s Complement
For a given string of binary number bi. Find the two’s complement of it.

You do not need to read input or print anything. Your task is to complete the function complement() which takes bi as input parameter and returns the 2''''s complement of the number.*/

import java.io.*;
import java.util.*;

class Solution{
    static String complement(String binary){
      StringBuilder complement = new StringBuilder();

        // invert each bit of the binary string
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                complement.append('1');
            } else {
                complement.append('0');
            }
        }

        // add 1 to the complement
        int carry = 1;
        StringBuilder twosComplement = new StringBuilder();
        for (int i = complement.length() - 1; i >= 0; i--) {
            int sum = (complement.charAt(i) - '0') + carry;
            if (sum == 2) {
                twosComplement.insert(0, '0');
                carry = 1;
            } else {
                twosComplement.insert(0, sum);
                carry = 0;
            }
        }

        return twosComplement.toString();
    }
}


public class Main{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String bi = in.readLine();
        Solution ob = new Solution();
        System.out.println(ob.complement(bi));
    }
}
