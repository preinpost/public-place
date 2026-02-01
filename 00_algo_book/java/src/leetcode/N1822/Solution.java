package leetcode.N1822;

// 1822. Sign of the Product of an Array
class Solution {
    public int arraySign(int[] nums) {
        boolean flag = false;

        for (int i : nums) {
            if (i == 0) return 0;
            else if (i < 0) flag = !flag;
        }

        if (flag == false) return 1;
        else return -1;
    }
}