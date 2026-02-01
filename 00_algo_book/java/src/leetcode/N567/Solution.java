package leetcode.N567;

import java.util.Arrays;

// 567. Permutation in String
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;

        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for (int i = 0; i < n1; i++) {
            a1[s1.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < n2; i++) {
            a2[s2.charAt(i) - 'a'] += 1;

            if (i >= n1) {
                a2[s2.charAt(i - n1) - 'a'] -= 1;
            }

            if (Arrays.equals(a1, a2)) return true;
        }

        return false;
    }
}
