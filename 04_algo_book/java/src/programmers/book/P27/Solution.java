package programmers.book.P27;

import java.util.*;

// P27. 문자열 내 마음대로 정렬하기
class Solution {
    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) == s2.charAt(n)) {

                int minLength = Math.min(s1.length(), s2.length());

                for (int i = 0; i < minLength; i++) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        return (int) s1.charAt(i) - (int) s2.charAt(i);
                    }
                }

                return 0;

            } else {
                return (int) s1.charAt(n) - (int) s2.charAt(n);
            }
        });

        return strings;
    }
}