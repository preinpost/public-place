package leetcode.N413;

public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int falseCnt = 0;
        int totCnt = 0;

        if (nums.length < 3) return 0;

        int currentLength = 3;

        int p1 = 0;
        int p2 = currentLength;

        while (currentLength <= nums.length) {

            int sequence = nums[p1+1] - nums[p1];
            for (int i = p1+1; i < p2; i++) {
                if (sequence != nums[i] - nums[i-1]) {
                    falseCnt++;
                    break;
                }

            }

            totCnt++;
            p1++;
            p2++;

            if (p2 > nums.length) {
                currentLength++;
                p1 = 0;
                p2 = currentLength;
            }
        }

        return totCnt - falseCnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[] {1, 2, 3};

        System.out.println(solution.numberOfArithmeticSlices(nums));
    }
}
