/*The Remaining One
Alex is given list arr of all integers in the range [1, n] sorted in a strictly increasing order.

You can apply the following operation on arr:

Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.

Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.

Keep repeating the steps again, alternating left to right and right to left, until a single number remains.

Your task is to find out the remaining number in arr after applying the given operation.

Input Format
The fitst line of input contains a single Integer n.

Output Format
Return the last number that remains in arr.

Example 1
Input

9
Output

6*/

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Main {
    
    
	public static void main (String[] args) throws IOException{
	    Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();

		Solution obj=new Solution();

		System.out.println(obj.solve(n));
            
        
    }
}

//O(LOG N)
class Solution
{
	
    public int solve(int n)
    {
       if(n==1)return 1;

		int small = 2 * (1+n/2 - solve(n/2));

		return small;
		
    }
}
