import java.util.*;

class Solution {
    public int longestSubstring(String s) {
        int maxLength = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (charIndexMap.containsKey(ch)) {
                // Move the left pointer to the right of the last occurrence of the character.
                left = Math.max(left, charIndexMap.get(ch) + 1);
            }
            // Update the index of the current character.
            charIndexMap.put(ch, right);
            // Update the maximum length of substring.
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Solution ob = new Solution();
        int ans = ob.longestSubstring(s);
        System.out.println(ans);
    }
}
