package leetcode.N2405;

import java.util.HashSet;
import java.util.Set;

// 2405. Optimal Partition of String
class Solution {
    public int partitionString(String s) {

        Set<Integer> set = new HashSet<>();
        int answer = 1;

        for (int i = 0; i < s.length(); i++) {
            int currChar = s.charAt(i);

            if (set.contains(currChar)) {
                set.clear();
                answer += 1;
            }

            set.add(currChar);
        }

        return answer;
    }
}