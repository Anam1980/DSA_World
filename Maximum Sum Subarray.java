// Java program to print largest contiguous array sum
import java.util.*;

public class Main {

  // Driver Code
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    sc.close();
    System.out.println(maxSubArraySum(arr));
  }

  // Function Call
  static int maxSubArraySum(int a[]) {
    int maxSum = Integer.MIN_VALUE;
	int prevSum=0;

	  for(int i=0; i<a.length; i++){
		  int first = a[i];
		  int sec = prevSum + a[i];

		  prevSum = Math.max(first, sec);

		  maxSum = Math.max(prevSum, maxSum);
	  }

	  return maxSum;
  }
}
