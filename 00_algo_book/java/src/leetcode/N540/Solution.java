package leetcode.N540;

// 540. Single Element in a Sorted Array
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (m % 2 == 0) {
                // answer left
                if (nums[m] != nums[m - 1]) return nums[m - 1];
                r = m - 2;
            } else {
                // answer right
                if (nums[m] != nums[m + 1]) return nums[m + 1];
                l = m + 2;
            }
        }
        return -1;
    }
}