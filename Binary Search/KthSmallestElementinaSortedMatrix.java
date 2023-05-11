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

            while(i<=n-1 && j>=0){
                //count the number of elemnet less than or equal to mid value
                if(matrix[i][j]<=mid){
                    count+=j+1;
                    i++;
                }
                else{
                    j--;
                }
            }

            //update the range of ans value
            if(count<k){
                st=mid+1;
            }
            else{
                end=mid-1;
                ans=mid;
            }
        }

        return ans;
    }
}
