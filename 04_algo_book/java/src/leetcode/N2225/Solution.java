package leetcode.N2225;

import java.util.*;

// 2225. Find Players With Zero or One Losses
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        Map<Integer, Integer> map = new HashMap<>();

        List<List<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> ar1 = new ArrayList<>();
        ArrayList<Integer> ar2 = new ArrayList<>();

        for (int i = 0; i < matches.length; i++) {

            map.put(matches[i][0], map.getOrDefault(matches[i][0], 0));
            map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) - 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                ar1.add(entry.getKey());
            }

            if (entry.getValue() == -1) {
                ar2.add(entry.getKey());
            }
        }

        Collections.sort(ar1);
        Collections.sort(ar2);

        answer.add(ar1);
        answer.add(ar2);

        return answer;

    }
}