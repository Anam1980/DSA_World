/*A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, 
if all the permutations of the array are sorted in one container according to their lexicographical order,
then the next permutation of that array is the permutation that follows it in the sorted container. 
If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.*/

//TC _O(N) SC_O(1)


class Solution {
    public void nextPermutation(int[] nums) {
        //small=n-1
        //find the best small which will to swap
        //find the element whcch swap with small
        //swap them
        //reverse from small+1 to last

        int n=nums.length;

        //2 3 1
        int first=n-2; //first = 3

        while(first>=0 && nums[first] >= nums[first+1]){
            first--;
        }
        //first = 2

        if(first >= 0){
            int sec = n-1;//1

            while(sec>=0 && nums[first] >= nums[sec]){
                sec--;
            }
            //sec = 3

            swap(nums, first, sec);// 3 2 1
        }

        reverse(nums, first+1, n-1);//3 1 2

    }

    void swap(int[]arr, int i, int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    void reverse(int[]arr, int st, int en){
        while(st<en){
            int tmp = arr[st];
            arr[st]=arr[en];
            arr[en]=tmp;

            st++;
            en--;
        }
    }
}
