/*Given an unsorted array Arr of size N of positive integers.
One number 'A' from set {1, 2, N} is missing and one number 'B' occurs twice in array. Find these two numbers.*/

class Solve {
    int[] findTwoElement(int A[], int n) {
        int[]ans = new int[2];

       int repeat = -1;
       int missing = -1;
       //traverse for marking
       for(int i=0; i<n; i++){

           int idx = (Math.abs(A[i])-1);

           if(A[idx] < 0){
               //already marked
               repeat = Math.abs(idx+1);
               
           }
           else{
               A[idx] = -A[idx];
           }

       }

       //for finding the missing one
       for(int i=0; i<n; i++){
           if(A[i] > 0){
               missing = i+1;
           }
       }

       ans[1]=missing;
       ans[0]=repeat;

       return ans;
    }
}
