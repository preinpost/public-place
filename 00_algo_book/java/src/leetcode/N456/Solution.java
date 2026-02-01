package leetcode.N456;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    /*
        Input: nums = [1,2,3,4]
        Output: false
        Explanation: There is no 132 pattern in the sequence.


        Input: nums = [3,1,4,2]
        Output: true
        Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

        Stack으로?




     */

    public boolean find132pattern(int[] nums) {

        Stack<Integer> stk = new Stack<>();
        int second = Integer.MIN_VALUE;

        for (int i = nums.length-1; i >= 0; i--) {

            if (nums[i] < second) {
                return true;
            }

            while (!stk.isEmpty() && stk.peek() < nums[i]) {
                second = stk.pop();
            }
            stk.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = new int[] {1,0,1,-4,-3};

        boolean result = sol.find132pattern(nums);
        System.out.println(result);
    }
}
