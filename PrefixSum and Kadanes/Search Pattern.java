/*Search Pattern
You are given two string a and b. Your task is find all the indices(1-based) where string b is present in string a as a substring.

If b is not present in a, return an array {-1}.*/

import java.util.*;

class Solution {
    public ArrayList<Integer> FindIndices(String a, String b) {
		
        ArrayList<Integer>list=new ArrayList<>();

		int n = b.length();

		boolean found=false;
		
		for(int i=0; i<a.length()-n+1; i++){
			String comp = a.substring(i, i+n);
			if(comp.equals(b)){
				found=true;
				list.add(i+1);
			}
		}

		if(!found){
			 list.add(-1);
			return list;
		}
		return list;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
	    Solution Obj = new Solution();
        ArrayList<Integer> ans = Obj.FindIndices(a, b);
        for(int x : ans)
            System.out.print(x + " ");
    }
}
