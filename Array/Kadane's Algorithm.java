/*Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.*/

class Solution {
    public int maxSubArray(int[] nums) {
        //store the prev maxsum
        int prevSum=0;

        //overall maxSum
        int maxSum=Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            int curr = nums[i];//itself
            int currSum = prevSum + curr;//prev+itself

            prevSum = Math.max(curr, currSum);//update prevSum

            //update maxSum
            maxSum = Math.max(maxSum, prevSum);
        }
        return maxSum;
    }
}
