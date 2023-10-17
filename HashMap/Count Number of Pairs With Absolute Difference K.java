//Count Number of Pairs With Absolute Difference K

import java.io.*;
import java.util.*;

class Solution {
    public long pairDifference(int []A, int n, int k) {
      Map<Integer, Integer>hm=new HashMap<>();
		long cnt=0;
		for(int i=0; i<n; i++){
			hm.put(A[i], hm.getOrDefault(A[i], 0)+1);
		}

		if(k==0){
			for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
				if(entry.getValue()>1)cnt++;
			}
			return cnt;
		}
		for(Map.Entry<Integer, Integer> entry : hm.entrySet()){

			if(hm.containsKey(entry.getKey()-k)){
				
					cnt++;	
				 
			}
	
		}
		return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int []mat=new int[n];
        for(int i=0;i<n;++i){
            mat[i]=sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.pairDifference(mat,n,k));
        System.out.println('\n');
    }
}
