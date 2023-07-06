class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //add all the elemnets of nums1 with their index in Map
        HashMap<Integer, Integer>hm = new HashMap<>();

        for(int i=0; i<nums1.length; i++){
            hm.put(nums1[i], i);
        }

        Stack<Integer>st = new Stack<>();

        for(int i=0; i<nums2.length; i++){
            int currval = nums2[i];

            while(st.size()>0 && currval > nums2[st.peek()]){
                int stidx = st.peek();
                st.pop();

                if(hm.containsKey(nums2[stidx])){
                    int idx = hm.get(nums2[stidx]);
                    nums1[idx]=currval;
                }
                
            }
            st.push(i);
        }

        while(st.size()>0){
            int stidx = st.peek();
                st.pop();

                if(hm.containsKey(nums2[stidx])){
                    int idx = hm.get(nums2[stidx]);
                    nums1[idx]=-1;
                }
        }

        return nums1;
    }
}
