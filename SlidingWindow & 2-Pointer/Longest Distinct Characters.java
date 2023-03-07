import java.io.*;
import java.util.*;

class Solution {
    public static int longestUniqueSubsttr(String str)
    {
        int n = str.length();
        Set<Character> set = new HashSet<Character>();
        int st = 0;
		int en = 0;
		int maxLen = 0;
        while (en<n) {
            if (!set.contains(str.charAt(en))) {
                set.add(str.charAt(en));
                maxLen = Math.max(maxLen, en - st + 1);
				en++;
            } else {
                set.remove(str.charAt(st));
				st++;
            }
        }
        return maxLen;
    }
}

public class Main {
     public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution obj = new Solution();
        int len = obj.longestUniqueSubsttr(str);
        System.out.println(len);
    }
}

