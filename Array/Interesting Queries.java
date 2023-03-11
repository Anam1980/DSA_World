/*Given an array nums of n elements and q queries . Each query consists of two integers l and r .
You task is to find the number of elements of nums[] in range [l,r] which occur atleast k times.*/

class Solution
{
    //T:O(n^2)  SC:O(n)>>>>>>BRUTE FORCE<<<<<<<<<<<<<<<<<<<<<<<<
    public int[] solveQueries(int[] nums, int[][] Queries, int k)
    {
        // Code here 
        //create anss array
        int[]ans=new int[Queries.length];
        
        //idx variable for ans array idx
        int idx=0;
       
       //queries ranges
        for(int[] query : Queries){
            //as 0 based indexing
            int l=query[0]-1;
            int r=query[1]-1;
            
            //variable to count the freq atleast k
            int cnt=0;
            
            //Map to store the elements  and their frequency within query range 
            HashMap<Integer, Integer>hm=new HashMap<>();
            
            //traverse between range
            for(int i=l; i<=r; i++){
                //add element and freq as key-value pair
                 hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
            }
            
            //traverse through map to check the atleast k freq elemnents count
            for(int key : hm.keySet()){
                if(hm.get(key)>=k){
                    cnt++;
                }
            }
            
            //put in ansarray
            ans[idx]=cnt;
            //update index
            idx++;
        }
        return ans;
    }
}
