package programmers.book.P32;

import java.util.*;

// P32. 징검다리
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        rocks = Arrays.copyOf(rocks, rocks.length + 1);
        rocks[rocks.length - 1] = distance;
        Arrays.sort(rocks);

        int from = 1;
        int to = distance + 1;

        while (from < to) {
            int mid = (from + to) / 2;

            if (n < count(mid, rocks)) {
                to = mid;
            } else {
                from = mid + 1;
            }
        }

        return to - 1;
    }


    private int count(int d, int[] rocks) {
        int removeCnt = 0;
        int position = 0;

        for (int rock: rocks) {
            if (rock - position < d) {
                removeCnt += 1;
                continue;
            }

            position = rock;
        }

        return removeCnt;
    }
}