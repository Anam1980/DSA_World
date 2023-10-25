import java.util.*;
 
class Solution {
    public int[] population(int[] nums) {
		List<Integer>list = new ArrayList<>();
		int carry = 1 ;
        for(int i =nums.length-1 ; i>=0; i--){
			int curr = nums[i] + carry;

			if(curr>=10){
				carry = curr/10;
			}
			else{
				carry = 0;
			}

			list.add(curr%10);
		}

		if(carry>0){
			list.add(carry);
		}

		Collections.reverse(list);

		int[] ans = new int[list.size()];
		int idx = 0;
		for(int n : list){
			ans[idx] =n;
			idx++;
		}
		return ans;
      }
}
 
public class Main{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
       }
        sc.close();
        Solution Obj = new Solution();
        int[] a=Obj.population(arr);
       for(int i=0;i<a.length;i++)
        System.out.print(a[i]+" ");
    }
}
