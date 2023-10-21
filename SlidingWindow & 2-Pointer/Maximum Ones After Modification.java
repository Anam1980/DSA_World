class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero=0;
        int lonArr=0;
        int st = 0;
        int end = 0;

        while(end<nums.length){
            if(nums[end]==0)zero++;

            while(zero>k && st<=end){
                if(nums[st]==0)zero--;
                st++;
            }
             lonArr = Math.max(lonArr, (end-st+1));

            end++;
        }

        return lonArr;
    }
}
