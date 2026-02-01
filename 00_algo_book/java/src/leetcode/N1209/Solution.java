package leetcode.N1209;

import java.util.Stack;

public class Solution {

    /*
        abcabcaacb, k = 2

        charStk a b c a -b -c -a a- -c -b
        cntStk  1 1 1 1 -1 -1 -1 2- -2 -2

     */

    public String removeDuplicates(String s, int k) {

        Stack<Character> charStk = new Stack<>();
        Stack<Integer> cntStk = new Stack<>();

        for (char c : s.toCharArray()) {

            if (charStk.isEmpty() || charStk.peek() != c) {
                charStk.push(c);
                cntStk.push(1);
            } else {
                charStk.push(c);
                cntStk.push(cntStk.peek()+1);

                if (cntStk.peek() == k) {
                    for (int i = 0; i < k; i++) {
                        charStk.pop();
                        cntStk.pop();
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!charStk.isEmpty()) sb.append(charStk.pop());

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "pbbcggttciiippooaais";
        int k = 2;

        String result = sol.removeDuplicates(s, k);
        System.out.println(result);

    }
}
