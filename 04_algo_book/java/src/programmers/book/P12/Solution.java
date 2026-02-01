package programmers.book.P12;

import java.util.*;

// P12. 숫자 문자열과 영단어
class Solution {
    public int solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        StringBuilder builder = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                builder.append(c);
            } else {
                tmp.append(c);
            }
            if (map.containsKey(tmp.toString())) {
                builder.append(map.get(tmp.toString()));
                tmp = new StringBuilder();
            }
        }

        if (tmp.length() > 0) {
            builder.append(map.get(tmp.toString()));
        }

        return Integer.parseInt(builder.toString());
    }
}
