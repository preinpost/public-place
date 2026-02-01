package programmers.book.P16;

import java.util.ArrayList;
import java.util.List;


// P16. 하노이의 탑
class Solution {
    public int[][] solution(int n) {
        int[][] answer = {};

        List<int[]> list = new ArrayList<>();

        hanoi(n, 1, 3, list);

        return list.toArray(new int[0][]);
    }

    public void hanoi(int n, int from, int to, List<int[]> answer) {
        if (n == 1) {
            answer.add(new int[] {from, to});
            return;
        }

        int other = 6 - from - to;

        hanoi(n - 1, from, other, answer);
        hanoi(1, from, to, answer);
        hanoi(n - 1, other, to, answer);
    }
}
