package leetcode.N905;

/*
    Input: nums = [3,1,2,4]
    Output: [2,4,3,1]
    Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */

/*
    Case
        1 2 4 7 - 양 끝이 둘다 홀수일 때
            -> p2--

        1 2 3 6 - 왼쪽이 홀수 오른쪽이 짝수일 때
            -> Swap 후 p1++ p2--

        6 3 2 1 - 왼쪽이 짝수 오른쪽이 홀수일 때
            -> p1++ p2--

        2 1 7 4 - 양 끝이 둘다 짝수일 때
            -> p1++
 */


public class Solution {

    public int[] sortArrayByParity(int[] nums) {

        int p1 = 0;
        int p2 = nums.length - 1;

        while (p1 <= p2) {

            int p1_val = nums[p1] % 2;
            int p2_val = nums[p2] % 2;

            if (p1_val == 1 && p2_val == 1) {
                p2--;
            } else if (p1_val == 1 && p2_val == 0) {
                int tmp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = tmp;

                p1++;
                p2--;
            } else if (p1_val == 0 && p2_val == 1) {
                p1++;
                p2--;
            } else {
                p1++;
            }

        }

        return nums;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = new int[]{3, 1, 2, 4};

        int[] result = sol.sortArrayByParity(nums);

        for (int i : result) {
            System.out.print(i + " ");
        }

    }
}
