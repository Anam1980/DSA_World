/*Number of Substrings Containing All Three Characters
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Your task is to complete the function numberOfSubstrings which receives the input string and returns the number of substrings containing at least one occurrence of all these characters a, b and c.*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	   public static void main(String args[]) {
		  
		   Scanner sc = new Scanner(System.in);
	        String s = sc.nextLine();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.numberOfSubstrings(s));
	    }
}
class Solution{
	   public static int numberOfSubstrings(String s) {
             int n = s.length();
    int left = 0, right = 0, count = 0, res = 0;
    int[] freq = new int[3];
    
    while (right < n) {
        char c = s.charAt(right);
        freq[c-'a']++;
        while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
            count++;
            freq[s.charAt(left)-'a']--;
            left++;
        }
        res += count;
        right++;
    }
    return res;
}
}
