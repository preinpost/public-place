package programmers.book.P37;

import java.util.*;

// P37. 완주하지 못한 선수
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> p_hashmap = new HashMap<>();

        for (String p : participant) {
            p_hashmap.put(p, p_hashmap.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            if (!p_hashmap.containsKey(c)) return c;

            if (p_hashmap.get(c) - 1 == 0) {
                p_hashmap.remove(c);
            } else {
                p_hashmap.put(c, p_hashmap.get(c) - 1);
            }
        }
        return p_hashmap.keySet().iterator().next();
    }
}