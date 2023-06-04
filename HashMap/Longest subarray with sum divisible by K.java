class Solution{
    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
       HashMap<Integer, Integer> hm = new HashMap<>();
       
       int sum=0;
       int len=0;
       
       hm.put(0, -1);
       
       for(int i=0; i<n; i++){
           sum+=a[i];
           
           //check
           int rem = (sum%k);
           
           //for negative value mark the value with same bnumber i.e. k
           if(rem<0){
               rem = k + rem;
           }
           
           //if present
           if(hm.containsKey(rem)){
               len=Math.max(len, (i-hm.get(rem)));
           }
           //add to map
           else{
               hm.put(rem, i);
           }
       }
       
       return len;
       
       
    }
 
}
