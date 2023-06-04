class Solution {
    
   
    String printLargest(String[] arr) {
        
       Arrays.sort(arr, (a, b)->(a+b).compareTo(b+a));
       
       String str="";
       
       for(int i=arr.length-1; i>=0; i--){
           str+=arr[i];
       }
       
       return str;
       
    }
}
