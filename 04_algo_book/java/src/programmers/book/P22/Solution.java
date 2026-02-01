package programmers.book.P22;

import java.util.*;

// P22. 불량 사용자
class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*', '.'))
                .map(banned -> Arrays.stream(user_id)
                        .filter(id -> id.matches(banned))
                        .toArray(String[]::new))
                .toArray(String[][]::new);

        Set<String> banned = new HashSet<>();
        Set<Set<String>> memory = new HashSet<>();

        count(0, banned, bans, memory);

        return memory.size();
    }

    private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> memory) {
        if (index == bans.length) {
            memory.add(new HashSet<>(banned));
            return;
        }

        for (String s : bans[index]) {
            if (banned.contains(s)) continue;

            banned.add(s);
            count(index + 1, banned, bans, memory);
            banned.remove(s);
        }
    }
}