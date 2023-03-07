/*Sliding window Maximum
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the maximum of each sliding window.

Complete the given function SlidingWindowMaximum which receives the input array, n and k as its parameters and returns an array containing maximum of each window of size k.*/

import java.util.*;

class Solution{
   
        public static int[] SlidingWindowMaximum( int n, int k, int[] nums) {
        int[] result = new int[n - k + 1];
        Deque<Integer> window = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // remove elements outside the current window
            while (!window.isEmpty() && window.peek() < i - k + 1) {
                window.poll();
            }

            // remove elements from the end of the window that are smaller than the current element
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }

            // add the current element to the window
            window.offer(i);

            // add the maximum of the current window to the result
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[window.peek()];
            }
        }
			return result;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
