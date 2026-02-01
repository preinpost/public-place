package leetcode.N3;

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        HashSet<Character> set = new HashSet<>();

        int p1 = 0;
        int p2 = 0;
        int answer = 0;

        while (p2 < s.length()) {
            if (set.contains(s.charAt(p2))) {
                answer = Math.max(answer, set.size());
                set.remove(s.charAt(p1));
                p1 += 1;
            } else {
                set.add(s.charAt(p2));
                p2 += 1;
            }
        }

        answer = Math.max(answer, set.size());

        return answer;
    }
}