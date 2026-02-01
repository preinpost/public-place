import java.util.*;

class Solution {

    public int countNicePairs(int[] nums) {

        long answer = 0;
        int numsLength = nums.length;
        long[] condNums = new long[numsLength];

        Map<Long, Long> numMap = new HashMap<>();

        for (int i = 0; i < numsLength; i++) {
            condNums[i] = nums[i] - reverseNumber(nums[i]);
        }

        for (long l : condNums) {
            numMap.put(l, numMap.getOrDefault(l, 0l) + 1);
        }

        for (long k : numMap.keySet()) {
            long cnt = numMap.get(k);

            if (cnt < 2) {
                continue;
            }

            answer += combi(cnt);
        }

        return (int) answer % (1000000000 + 7);
    }

    private long reverseNumber(long num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        return Long.parseLong(sb.reverse().toString());
    }

    private long combi(long n) {
        return (n * (n - 1) / 2) % (1000000000 + 7);
    }
}