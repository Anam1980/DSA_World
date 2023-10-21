import java.io.*;
import java.util.*;

public class Main {
// 	When it comes to Sum of Subarray, the use of Prefix Sum is especially important.
  
// Prefix Sum is the sum of the current integer with the previous integer in the array (Prefix).

// Example: nums = [1,2,3,4,5] has the prefix sum array of prefixSum = [1,3,6,10,15], where the nums[0] + 1 = 1, nums[1] + nums[0] = 2 + 1 = 3, nums[2] + nums[1] = 3 + 3 = 6, and so on.

// Using the example above, we can determine the subarray sum of any subarray using prefix sum.

// To get the subarray sum of nums[2] to nums[4] == 3 + 4 + 5 == 12, we can get from prefixSum[5] - prefixSum[1] == 15 - 3 == 12.

// With Prefix Sum, we can evaluate if any subarray sum is divisible by 'k', if two prefix sums have the same remainder of 'k'.

// For Example, nums = [4,2,3], k = 5, with two prefix sum, 4 [4] and 9 [4,2,3].

// Both remainders are 4, with the subarray between the prefix sum 9 [4,2,3] - 4 [4] == 5 [2,3], which is divisible by 5.

    public static int subarrayDivisbleByK(int arr[], int n, int k){
         HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int ans = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            int rem = sum % k;

            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem)) {
                ans += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
        }
        int result = subarrayDivisbleByK(arr, n, k);
        System.out.print(result);        
        System.out.println('\n');
    }
}
