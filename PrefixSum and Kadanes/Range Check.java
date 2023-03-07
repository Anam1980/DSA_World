/*Range Check
You are given a 2D array intervals of size n x 2. Each intervals[i] = [start, end] represents an interval from start to end (both inclusive).

You are also given a range [a, b]. You need to find that all the integers in between a and b(both inclusive) are covered in atleast one of the interval of array intervals.

Return true is the condition is satisfied, else return false.*/


import java.util.*;

class Solution {
    public boolean RangeCheck(int[][] intervals, int a, int b) {

	for(int i=a; i<=b; i++){
		boolean flag=false;
		for(int[] rng : intervals){
			if(i>=rng[0] && i<=rng[1]){
				flag=true;
				break;
			}
		}
		if(flag==false){
			return false;
		}
	}
		return true;
   }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[][] intervals = new int[n][2];
        for(int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
	    Solution Obj = new Solution();
        if(Obj.RangeCheck(intervals, a, b))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
