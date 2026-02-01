package leetcode.N283;

class Solution {
    public void moveZeroes(int[] nums) {

        int p1 = 0;
        int p2 = 0;

        while (p2 < nums.length) {
            if (nums[p2] != 0) {
                swap(nums, p1, p2);
                p1++;
            }
            p2++;
        }
    }

    void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}