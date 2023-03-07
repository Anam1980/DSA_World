/*Boats to Save People
You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.*/

import java.io.*;
import java.util.*;
class Solution
{
      public static int numRescueBoats(int[] people, int limit) {
       Arrays.sort(people);
	   int lightwgt=0;
	  int hevywght=people.length-1;
		  int boats=0;

		  while(lightwgt<=hevywght){
			  int sum=people[lightwgt]+people[hevywght];
			  if(sum<=limit){
				  lightwgt++;
				  hevywght--;
			  }
			  else{
				  hevywght--;
			  }
			  boats++;
		  }

		  return boats;
      }
}
public class Main {
	

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
		System.out.println(Solution.numRescueBoats(nums, k));
	}

}
