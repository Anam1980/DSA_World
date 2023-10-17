import java.io.*;
import java.util.*;

class Solution {
    public void nonRepeatingCharacter(String s) {
      int n=s.length();
        int[] f = new int[26];
        for(int i = 0; i < n; i++){
            f[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < n; i++){
            if(f[s.charAt(i)-'a'] == 1){
                System.out.println(s.charAt(i));
                return;
            }
        }
        System.out.println(-1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        s=sc.next();
        Solution Obj = new Solution();
        Obj.nonRepeatingCharacter(s);  
        System.out.println();
    }
}
