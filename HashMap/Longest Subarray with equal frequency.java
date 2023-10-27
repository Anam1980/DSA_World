import java.util.*;

class Solution{
    public static int longestSubarray(int[] arr){
        //create hashmap to store the code and index
		HashMap<String, Integer>mp=new HashMap<>();

		//add initial val
		mp.put("0#0", -1);

		int max=0;

		//variable to store frequency of 0, 1, 2
		int count0=0;
		int count1=0;
		int count2=0;

		for(int i=0;i<arr.length;i++){
			//count 0, 1, 2
			if(arr[i]==0){
				count0++;
			}
			else if(arr[i]==1){
				count1++;
			}
			else{
				count2++;
			}

			//make a code which shows the the subarray with equal freq
			int d10=count1-count0;
			int d21=count2-count1;

			String code=d10+"*"+d21;

			//if code already present means upto that index to this index equal freq
			if(mp.containsKey(code)){
				int fidx=mp.get(code);
				int dist=i-fidx;
				max=Math.max(max, dist);
			}
			else{
				mp.put(code, i);
			}
		}
		return max;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubarray(arr));
    }
}
