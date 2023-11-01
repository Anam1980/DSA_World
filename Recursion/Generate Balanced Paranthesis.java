import java.io.*;
import java.util.*;
class Solution{
    public static void helper(int n, int l, int r, String st){
        if(st.length()==2*n){
         System.out.println(st);
        return;
        }

        if(l<n){
       helper(n, l+1, r, st+'(');
        }
        if(r<l){
       helper(n, l, r+1, st+')');
        }
   
    }
     public static void generateParanthesis(int n){
      helper(n, 0, 0, "");   
         
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Solution obj=new Solution();
        obj.generateParanthesis(n);
    }
}
