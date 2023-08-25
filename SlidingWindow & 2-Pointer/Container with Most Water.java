import java.util.*;

class Solution {
   static Long mostWater(int size, int arr[]) {
        int i =0;
	   int j = size-1;

	   Long maxArea = 0L;

	   while(i<j){
		   int area = Math.min(arr[i], arr[j]) * (j-i);

		   maxArea = Math.max(maxArea, area);

		   //want max
		   if(arr[i]>arr[j]){
			   j--;
		   }
		   else{
			   i++;
		   }
	   }

	   return maxArea;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.mostWater(n,array));
    }
}
