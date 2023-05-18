//TWO POINTER APPROACH

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        //two pointer

        int n= nums.length;
        int j=-1;
        long ans=0;

        for(int i=0; i<n; i++){
            //zero comes count upto that array
            if(nums[i]==0){
                ans+=(long)(i-j);
            }
            //move the previous pointer
            else{
                j=i;
            }
        }

        return ans;
    }
}

//SLIDING WINDOW APPROACH

class Accio {
    public long zeroFilledSubarray(int[] arr,int n) {
	long zeros = 0;
        long total = 0;
        for (int i = 0; i < n; i++) {
          //count zeros and update pointer for zeros subarray
            while (i < n && arr[i] == 0) {
                zeros++;
                i++;
            }
          
          //add no. of element in that window
            total += (zeros*(zeros+1))/2;
          
          //make zero to default
            zeros = 0;
        }
        return total;
    }
}
