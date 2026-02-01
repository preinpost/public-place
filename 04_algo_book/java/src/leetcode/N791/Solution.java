package leetcode.N791;

// 791. Custom Sort String
class Solution {
    public String customSortString(String order, String s) {

        StringBuilder answer = new StringBuilder();
        int[] table = new int[26];

        for (char c : s.toCharArray()) {
            table[c - 'a'] += 1;
        }

        for (char c : order.toCharArray()) {
            int count = table[c - 'a'];
            for (int i = 0; i < count; i++) {
                answer.append(c);
            }
            table[c - 'a'] = 0;
        }

        for (int i = 0; i < 26; i++) {
            if (table[i] != 0) {
                int count = table[i];
                for (int j = 0; j < count; j++) {
                    answer.append((char)(i + 'a'));
                }
            }
        }

        return answer.toString();
    }
}