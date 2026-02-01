package programmers.book.P30;

import java.util.*;

// P30. 순위 검색
class Solution {
    public int[] solution(String[] info, String[] query) {

        Map<String, List<Integer>> infoMap = new HashMap<>();

        for (String i : info) {
            makeInfo(0, "", i.split(" "), infoMap);
        }

        for (List<Integer> li : infoMap.values()) {
            Collections.sort(li);
        }

        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            int cnt = findLowerbound(query[i], infoMap);
            answer[i] = cnt;
        }

        return answer;
    }

    private void makeInfo(int index, String acc, String[] s, Map<String, List<Integer>> infoMap) {

        if (index == s.length - 1) {
            infoMap.putIfAbsent(acc, new ArrayList<>());
            infoMap.get(acc).add(Integer.parseInt(s[s.length - 1]));

            return;
        }

        makeInfo(index + 1, acc + s[index], s, infoMap);
        makeInfo(index + 1, acc + "-", s, infoMap);
    }

    private int findLowerbound(String query, Map<String, List<Integer>> infoMap) {
        String[] q = query.split(" (and )?");
        String key = String.join("", Arrays.copyOf(q, q.length - 1));

        if (!infoMap.containsKey(key)) return 0;

        List<Integer> scoreList = infoMap.get(key);
        int score = Integer.parseInt(q[q.length - 1]);

        int start = 0;
        int end = scoreList.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (scoreList.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return scoreList.size() - end;
    }
}