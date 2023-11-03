import java.util.*;

class Solution{
public static void solve(int n, int[] arr) {
Arrays.sort(arr);///sort the array to rearrange and easily calculate the subsequence of each elemnt
    int left = 0;
    int right = 0;
   long tuple = 0;
    
    
while(right<n){

    int cnt = 0;
    while(right<n && arr[right]<=arr[left]+2){
        right++;
    }

    int windowsize = (right - left - 1);//ize excluding curr element
    cnt +=(long) windowsize * (windowsize - 1)/2;//nCr, n=size od window , r = 3
    //c = n!/r!(n-r)! = n*(n-1)*(n-2) / (3*2*1) 

    tuple += cnt;//add to the tuple of that one element in how many sequences are present by comination formula
    

    left++;//move to next element
}    
    
System.out.print(tuple);
}
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution.solve(n, arr);
    }
}
