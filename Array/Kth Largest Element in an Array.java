/*Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

You must solve it in O(n) time complexity.*/


class Solution {
  
    public int findKthLargest(int[] nums, int k) {
        //use priority que to sort the arr
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }

        //run loop upto last k th largest element
        while(pq.size()>0 && k>1){
            pq.poll();
            k--;
        }

        return pq.peek();
    }
}
