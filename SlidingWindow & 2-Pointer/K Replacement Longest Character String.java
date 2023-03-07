/*K Replacement Longest Character String
Given a string s and an integer k.

You can perform following step on the string at most k times.

Choose any character of the string and change it to any other lowercase english letter

Now return the length of the longest substring containing the same letter you can get after performing the above operations.*/

import java.util.*;

public class Main {

    public static int characterReplacement(int n, int k,String s){
        
    int[] count = new int[26];
    int start = 0;
	int end = 0;
	int maxLen = 0;
	int maxCount = 0;

    while (end < n) {
		//add
        count[s.charAt(end) - 'a']++;
        maxCount = Math.max(maxCount, count[s.charAt(end) - 'a']);

		//remove
        while (end - start + 1 - maxCount > k) {
            count[s.charAt(start) - 'a']--;
            start++;
        }

		//valid

		
        maxLen = Math.max(maxLen, end - start + 1);
        end++;
    }

    return maxLen;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int ans = characterReplacement(n,k,s);
        System.out.println(ans);
    }
}
