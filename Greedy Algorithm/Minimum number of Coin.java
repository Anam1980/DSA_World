/*Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 } and a target value N.
Find the minimum number of coins and/or notes needed to make the change for Rs N. You must return the list containing the value of coins required. */

class Solution{
    //global list 
    static int dem[]=new int[]{ 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
    
    static int n=dem.length;
    
    static List<Integer> minPartition(int N)
    {
       List<Integer>ans=new ArrayList<>();
       
       for(int i=n-1; i>=0; i--){
           //find the greater element
           while(N >= dem[i]){
               //update N 
               N = N - dem[i];
               //add coins to list
               ans.add(dem[i]);
           }
       }
       
       return ans;
        
    }
}
