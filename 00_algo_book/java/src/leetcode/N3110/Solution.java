package leetcode.N3110;

class Solution {
    public int scoreOfString(String s) {

        int answer = 0;
        for (int l = 0; l < s.length() - 1; l++) {
            int r = l + 1;

            answer += Math.abs((int)s.charAt(l) - (int)s.charAt(r));

        }

        return answer;
    }
}
