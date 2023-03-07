/*Substring with Concatenation of All Words
You are given a string str and an array of strings words. All the strings in the array words are of the same length. A concatenated substring in str is a substring which contains all the strings in the words array in any permutation.

For Example: words = [ "uv", "wx", "yz" ] then the possible combinations of concatenation formed are "uvwxyz", "wxyzuv", "uvyzwx" etc. whereas "uzvwxy" is not.

You are required to return the starting indices of all the concatenated substrings in str. You can return the indices in any order.*/

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String str, String[] words) {
        Map<String, Integer>wordCount=new HashMap<>();
		for(int i=0; i<words.length; i++){
			wordCount.put(words[i], wordCount.getOrDefault(words[i], 0)+1);
		}
		List<Integer>ans=new ArrayList<>();
		
		int wordlength=words[0].length();
		int totalwordlen=wordlength * words.length;

		int strlen=str.length();
		
		for(int i=0; i<strlen-totalwordlen; i++){
			
			Map<String, Integer>currWordCount=new HashMap<>();

			for(int j=0; j<words.length; j++){
				String currstr=str.substring(i+j*wordlength, i+(j+1)*wordlength);
				currWordCount.put(currstr, currWordCount.getOrDefault(currstr, 0)+1);
			}

			if(wordCount.equals(currWordCount)){
				ans.add(i);
			}
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i=0;i<n;i++){
            words[i] = scn.next();
        }
        Solution Obj =  new Solution();
        List<Integer> indexes = Obj.findSubstring(str,words);
        Collections.sort(indexes);
        for(int i=0;i<indexes.size();i++){
            System.out.print(indexes.get(i) + " ");
        }
        System.out.println();
    }
}
