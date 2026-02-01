package leetcode.N35;

// 35. Search Insert Position
class Solution {
    public int searchInsert(int[] nums, int target) {

        int p1 = 0;
        int p2 = nums.length;
        int mid = 0;
        while (p1 < p2) {
            mid = p1 + (p2 - p1) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                p2 = mid;
            } else if (nums[mid] < target) {
                p1 = mid + 1;
            }
        }

        if (mid <= p2) return p2;
        else return p2 + 1;
    }
}