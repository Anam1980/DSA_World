/*Longest Substring with At Least K Repeating Characters
You are given a string str and a number k. You are required to find 
the length of the longest substring such that the frequency of each character in the substring is atleast k.*/

import java.util.*;

class Solution {
   public static int longestSubstring(String s, int k) {
    int n = s.length();
    int result = 0;
    
    // loop over all possible characters to use as the unique character count
    for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
        int[] count = new int[26];
        int numUnique = 0;
        int numNoLessThanK = 0;
        int left = 0;
        int right = 0;
        
        // move the right endpoint of the window
        while (right < n) {
            int index = s.charAt(right) - 'a';
            if (count[index] == 0) {
                numUnique++;
            }
            count[index]++;
            if (count[index] == k) {
                numNoLessThanK++;
            }
            right++;
            
            // move the left endpoint of the window if necessary
            while (numUnique > numUniqueTarget) {
                int leftIndex = s.charAt(left) - 'a';
                if (count[leftIndex] == k) {
                    numNoLessThanK--;
                }
                count[leftIndex]--;
                if (count[leftIndex] == 0) {
                    numUnique--;
                }
                left++;
            }
            
            // check if the current substring is valid and update the result
            if (numUnique == numUniqueTarget && numUnique == numNoLessThanK) {
                result = Math.max(result, right - left);
            }
        }
    }
    
    return result;
}


}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubstring(str,k));
    }
}
