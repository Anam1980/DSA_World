class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;

        int maxArea=0;

        while(l<r){
            //min(l, r)
            int length = Math.min(height[l], height[r]);

            int breadth = r - l;

            //area = length * breadth
            int currArea = length * breadth;

            maxArea = Math.max(maxArea, currArea);

            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }

        return maxArea;
    }
}
