import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n= matrix.length;
        int st=matrix[0][0];
        int end=matrix[n-1][n-1];

        int ans=Integer.MIN_VALUE;

        while(st<=end){
            int mid=(st+end)/2;
            int i=0;
            int j=n-1;

            int count=0;

            while(i<=n-1){
				// count number of elements less than or equal to mid
                while( j>=0 && matrix[i][j]>mid){
                    
                    j--;
                }
                count+=j+1;
				i++;
            }
              // Narrow down the range based on the count of elements less than or equal to middle
            if(count<k){
                st=mid+1;	
            }
            else{
                end=mid;
                
            }
        }

        return st;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }
        
        int k = sc.nextInt();
        
        Solution obj = new Solution();
        System.out.println(obj.kthSmallest(matrix, k));
        
        sc.close();
    }
}
