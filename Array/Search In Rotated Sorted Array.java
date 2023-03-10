/*There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that 
the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.*/

class Solution {
    public int search(int[] nums, int target) {
        //initialize the pointer
        int low=0;
        int high=nums.length-1;

        //maybe element only one so that we take equal also
        while(low<=high){

            int mid = (low+high)/2;

            if(target==nums[mid]){
                return mid;
            }

            if(nums[low]<=nums[mid]){
                //I am in sorted flow i.e.1 2 3 i.e. low is less than mid
                //upto mid all sorted
                //check between low and mid
                if(target >= nums[low] && target < nums[mid]){
                    //update high to be in a sorted section
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                //I am in unsorted flow 3 4 1 i.e high is greater than mid
                //after mid all sorted
                //check between mid and high
                if(target <= nums[high] && target > nums[mid]){
                    //update low to be in that unsorted section
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
