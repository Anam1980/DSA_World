/*Number of Valid Triangles
You are given an array arr of length n. Print the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.*/


import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            
            for (int j = i + 1; j < n - 1 ; j++) {
				int k = j + 1;
                while (k < n && arr[i] + arr[j] > arr[k]) {
					count++;
                    k++;
                }
                
            }
        }
        System.out.println(count);
    }
}
