import java.util.*;

class Solution{
    public int numRabbits(int[] answer) {
        HashMap<Integer, Integer>hm=new HashMap<>();
		for(int i=0;i<answer.length;i++){
			hm.put(answer[i], hm.getOrDefault(answer[i],0)+1);
		}
		int totalrabbits=0;
		for(int res:hm.keySet()){
			int grpsize=res+1;
			int rabb=hm.get(res);

			int nofullgrp=rabb/grpsize;
			if(rabb%grpsize>0){
				nofullgrp++;
			}

			totalrabbits+=nofullgrp * grpsize;
		}

		return totalrabbits;
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
        System.out.println(Obj.numRabbits(arr));
    }
}
