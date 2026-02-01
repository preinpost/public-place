package leetcode.N881;

import java.util.Arrays;

// 881. Boats to Save People
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int answer = 0;

        while (left <= right) {
            if (people[left] + people[right] > limit) {
                answer += 1;
                right -= 1;
            } else {
                answer += 1;
                left += 1;
                right -= 1;
            }
        }

        return answer;
    }
}