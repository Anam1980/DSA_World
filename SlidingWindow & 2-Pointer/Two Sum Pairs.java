/*Two Sum Pairs
Given an Array arr of size n have may or may not be repeated elements. A target sum 'target' is provided. Return Pair of target sum in which all pairs are unique.

If array have repeated element then return only unique pairs.

NOTE: Complete the twoSum function, input and output is already managed.*/

import java.util.*;

public class Main {

    public static List<List<Integer>> twoSum(int[] arr, int target) {
     List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i]);
                pair.add(arr[j]);
                result.add(pair);
                i++;
                j--;
                while (i < j && arr[i] == arr[i-1]) i++;
                while (i < j && arr[j] == arr[j+1]) j--;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int target = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        List<List<Integer>> res = twoSum(arr, target);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
            Collections.sort(list);
            String ans = "";
            for (int val : list) {
              ans += val + " ";
            }
            finalResult.add(ans);
        }
        Collections.sort(finalResult);
        for (String str : finalResult) {
            System.out.println(str);
        }
    }
}
