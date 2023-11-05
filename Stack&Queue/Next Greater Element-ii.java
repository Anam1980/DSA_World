import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	
	  public static void main (String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			    int n = Integer.parseInt(br.readLine().trim());
			    String inputLine[] = br.readLine().trim().split(" ");
			    int[] nums = new int[n];
			    for(int i=0; i<n; i++)nums[i]=Integer.parseInt(inputLine[i]);
			    int[] res = new Solution().nextLarger2(nums, n);
			    for (int i = 0; i < n; i++) 
			        System.out.print(res[i] + " ");
			    System.out.println();
		}
}
class Solution{
  
	public static int[] nextLarger2(int[] nums, int n)
    { 
       int[]nge = new int[n];

        Stack<Integer>st = new Stack<>();

        boolean flag = true;
        int i = 0;
        int cnt=1;
        while(i<n){
        if(cnt>2)break;
        
          while(!st.isEmpty() && nums[st.peek()]<nums[i%n]){
              int idx = st.pop();
              nge[idx] = nums[i%n];
          }
        
        if(i<n && flag){
        st.push(i);
        if(i==n-1){
            flag = false;
        }
        }
        
        i=(i+1)%n;
        if(i==n-1)cnt++;
        }

    while(st.size()>0){
    int idx = st.pop();
    nge[idx] = -1;
    }

    return nge;
}
}
