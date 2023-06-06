class Solution {
    public int findMin(int[] nums) {
        //mid<mid-1-->mid
        //mid>mid+1-->mid+1
        //min is always in unsorted part
        //l<r-->l

        int l=0;
        int r=nums.length-1;

        if(nums[l]<=nums[r]){
            return nums[l];
        }

        while(l<r){

            int mid = (l+r)/2;

            if(nums[mid+1]<=nums[mid])return nums[mid+1];

            if(nums[mid]<nums[mid-1])return nums[mid];

            if(nums[l]<=nums[mid]){
                //sorted part
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }

        return -1;
    }
}
