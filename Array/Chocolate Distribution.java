/*Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. 
Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :
1. Each student gets exactly one packet.
2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.*/

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
       //sort the list
       Collections.sort(a);
       
       //overall min
       long minAll = a.get(n-1);
       
       for(int i=0; i<n-m+1; i++){
           //first->min
           //last->max
           int min=a.get(i);
           int max=a.get(i+m-1);
           
           //max-min 
           minAll=Math.min(minAll, (max-min));
       }
       
       return minAll;
    }
}

//TC-O(N*LOG N) SC-O(1)
