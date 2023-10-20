import java.util.*;

class Solution {
    public String SmallestSubstring(String a, String b) {
        // Write your code here
        int[] m = new int[256];

        int ans = Integer.MAX_VALUE;
        int start = 0;
        int count = 0;
        for (int i = 0; i < b.length(); i++) {
            if (m[b.charAt(i)] == 0)
                count++;
            m[b.charAt(i)]++;
        }

        int i = 0;
        int j = 0;

        while (j < a.length()) {
            m[a.charAt(j)]--;
            if (m[a.charAt(j)] == 0)
                count--;
            if (count == 0) {
                while (count == 0) {
                    if (ans > j - i + 1) {
                        ans = Math.min(ans, j - i + 1);
                        start = i;
                    }
                    m[a.charAt(i)]++;
                    if (m[a.charAt(i)] > 0)
                        count++;
                    i++;
                }
            }
            j++;
        }

        if (ans != Integer.MAX_VALUE)
            return a.substring(start, ans + start);
        else
            return "-1";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next(), b = sc.next();
	    Solution Obj = new Solution();
        System.out.println(Obj.SmallestSubstring(a, b));
    }
}
