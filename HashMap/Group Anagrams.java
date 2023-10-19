class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //let''s create something amazing to arrange it ;)
        //so starts  to grp to all anagram 
        //the common in ANAM, MANA, AMAN, -> AANM
        //I got it 

        //create hashmap with list of string ooo ---return type of func

        Map<String, List<String>> mapo = new HashMap<>();

        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);

            String s = new String(ch);

            if(mapo.containsKey(s)==false){
                mapo.put(s, new ArrayList<>());
            }

            mapo.get(s).add(str);
        }

       List<List<String>> ans=new ArrayList<>();
		for(Map.Entry mapElements:mapo.entrySet()){
            List<String> list=(List)mapElements.getValue();
            ans.add(list);
        }
		Collections.sort(ans, new CustomComparator());
		return ans;
    }
}
