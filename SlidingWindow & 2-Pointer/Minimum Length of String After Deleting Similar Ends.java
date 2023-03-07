/*Minimum Length of String After Deleting Similar Ends
Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:

Pick a non-empty prefix from the string s where all the characters in the prefix are equal.

Pick a non-empty suffix from the string s where all the characters in this suffix are equal.

The prefix and the suffix should not intersect at any index.

The characters from the prefix and suffix must be the same.

Delete both the prefix and the suffix.

Your task is to return the minimum length of s after performing the above operation any number of times (possibly zero times).*/

import java.util.*;

class Solution {
	static int solve(String s) {
	 int n = s.length();
    int i = 0;
	int j = n - 1;
    while (i < j && s.charAt(i) == s.charAt(j)) {
        char c = s.charAt(i);
        while (i < j && s.charAt(i) == c) i++;
        while (i <= j && s.charAt(j) == c) j--;
    }
    return j - i + 1;
	}
}
public class Main{
	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.next();
      System.out.println(Solution.solve(s));
   }
}
