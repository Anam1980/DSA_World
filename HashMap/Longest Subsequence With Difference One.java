import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static int longestSubsequence(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int maximum = 0;

        for (int i = 0; i < n; i++)
        {
            int len = 0;
            if (map.containsKey(nums[i] - 1) && len < map.get(nums[i] - 1)) {
                  len = map.get(nums[i] - 1);
            } 
            if (map.containsKey(nums[i] + 1) && len < map.get(nums[i] + 1)) {
                  len = map.get(nums[i] + 1);
            }

            map.put(nums[i], len + 1);

            if (maximum < map.get(nums[i])) {
                maximum = map.get(nums[i]);
            }
        }
        return maximum;
		
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = longestSubsequence(nums);
        System.out.println(result);

        scanner.close();
    }
}
