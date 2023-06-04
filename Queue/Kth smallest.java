class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
         PriorityQueue<Integer>pq=new PriorityQueue<>();
         
         for(int i=0; i<arr.length; i++){
             pq.add(arr[i]);
         }
         
         while(k>1){
             pq.remove();
             k--;
         }
         
         return pq.peek();
    } 
}
