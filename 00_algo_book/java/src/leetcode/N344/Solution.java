package leetcode.N344;

class Solution {
    public void reverseString(char[] s) {
        int half = s.length / 2;

        for (int i = 0; i < half; i++) {
            swap(s, i, s.length -1 - i);
        }
    }

    public void swap(char[] s, int a, int b) {
        char tmp = s[a];
        s[a] = s[b];
        s[b] = tmp;
    }
}
