package programmers.book.P35;

import java.util.*;

// P35. A로 B 만들기
class Solution {
    public int solution(String before, String after) {

        if (cMap(before).equals(cMap(after))) return 1;
        return 0;
    }

    private Map<Character, Integer> cMap(String str) {

        Map<Character, Integer> hash = new HashMap<>();

        for (char c : str.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        return hash;
    }
}