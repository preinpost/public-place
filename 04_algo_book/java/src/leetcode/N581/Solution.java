package leetcode.N581;

import java.util.Arrays;

public class Solution {

    /*
        Input: nums = [2,6,4,8,10,9,15]
        Output: 5
        Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
     */

    public int findUnsortedSubarray(int[] nums) {
        int[] sortedNum = Arrays.stream(nums).sorted().toArray();

        int p1 = 0;
        int p2 = nums.length - 1;
        boolean p1_flag = false;
        boolean p2_flag = false;

        while (p1 <= p2) {

            if (!p1_flag && nums[p1] == sortedNum[p1]) p1++;
            else p1_flag = true;


            if (!p2_flag && nums[p2] == sortedNum[p2]) p2--;
            else p2_flag = true;

            if (p1_flag && p2_flag) return p2 - p1 + 1;
        }

        return 0;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{2,6,4,8,10,9,15};
        int result = sol.findUnsortedSubarray(nums);
        System.out.println(result);
    }


}
