import java.util.*;

class Solution {
    static int countEqualSubarray012(int arr[], int n)
    {
        HashMap<String, Integer>mp=new HashMap<>();
		mp.put("0#0", 1);

		int count0=0;
		int count1=0;
		int count2=0;

		int countSub=0;


		for(int i=0; i<n ; i++){
			if(arr[i]==0){
				count0++;
			}
			else if(arr[i]==1){
				count1++;
			}
			else{
				count2++;
			}

			//if 0==1 && 1==2 then equal freq
			int d01=count0-count1;
			int d12=count1-count2;

			String code=d01+"#"+d12;
	
				countSub+=mp.getOrDefault(code, 0);
			
			
				mp.put(code, mp.getOrDefault(code,0)+1);
			
			
		}
        
         return countSub;
    }   

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
    

        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.countEqualSubarray012(arr,N));

    }
}
