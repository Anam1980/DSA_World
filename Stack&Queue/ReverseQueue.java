import java.util.*;
import java.util.LinkedList;

class Solution {
    public Queue<Integer> reverseQueue(Queue<Integer> q) {
        Queue<Integer>que = new LinkedList<>();
        Stack<Integer>st = new Stack<>();
        while(q.isEmpty()==false){
            int val =q.remove();
            st.push(val);
        }

       while(st.isEmpty()==false){
           que.add(st.pop());
       }
        return que;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(scn.nextInt());
        }
        scn.close();
        Solution Obj = new Solution();
        Queue<Integer> ans = Obj.reverseQueue(q);
        while (!ans.isEmpty()) {
            System.out.print(ans.peek() + " ");
            ans.remove();
        }
    }
}
