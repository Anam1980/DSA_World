class Solution{
  public static int[] reverseArray(int[]arr){
    //intialize
    int start=0;
    int end=arr.length-1;
    
    while(start < end){
      //swap the elments
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
     
      //update pointers
      start++;
      end--;
    }
    
    return arr;
  }
}
