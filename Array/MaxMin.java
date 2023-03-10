/*Given an array A of size N of integers. Your task is to find the sum of minimum and maximum element in the array.*/

class Solution
{ 
    public static int findSum(int A[],int N) 
    {
        //intialize the variable
        int min=A[0];
        int max=A[0];
        
        //traverse to find the min max
        for(int i=1; i<N; i++){
            min=Math.min(min, A[i]);
            max=Math.max(max, A[i]);
        }
        //summation
        int sum=min+max;
        
        return sum;
    }
}
