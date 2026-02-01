package leetcode.N1768;

// 1768. Merge Strings Alternately
class Solution {
    public String mergeAlternately(String word1, String word2) {

        StringBuffer sb = new StringBuffer();

        int idx = 0;

        while (word1.length() > idx || word2.length() > idx) {

            if (word1.length() > idx) {
                sb.append(word1.substring(idx, idx+1));
            }

            if (word2.length() > idx) {
                sb.append(word2.substring(idx, idx+1));
            }

            idx += 1;

        }

        return sb.toString();
    }
}