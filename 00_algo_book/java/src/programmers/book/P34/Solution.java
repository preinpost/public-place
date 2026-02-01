package programmers.book.P34;

import java.util.*;

// P34. 중복된 문자 제거
class Solution {
    public String solution(String my_string) {
        StringBuilder builder = new StringBuilder();

        Set<Character> dupCheck = new HashSet<>();

        for (char c : my_string.toCharArray()) {

            if (!dupCheck.contains(c)) {
                builder.append(c);
                dupCheck.add(c);
            }
        }

        return builder.toString();
    }
}