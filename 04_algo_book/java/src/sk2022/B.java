package sk2022;

import java.util.LinkedList;
import java.util.Queue;

public class B {

    public int[][] solution(int n, boolean clockwise) {
        int[][] answer;

        answer = bfs(new Integer[]{0,0}, new Integer[]{0,n-1}, new Integer[]{n-1,n-1}, new Integer[]{n-1,0}, n, clockwise);

        return answer;
    }

    public int[][] bfs(Integer[] s1, Integer[] s2, Integer[] s3, Integer[] s4, int n, boolean clockwise) {

        int[][] map = new int[n][n];
        int[][] check = new int[n][n];

        int[] di;
        int[] dj;

        Queue<Integer[]> Q = new LinkedList<>();

        if (clockwise) {
            di = new int[]{0, 1, 0, -1, 0, 1, 0, -1};
            dj = new int[]{1, 0, -1, 0, 1, 0, -1, 0};

            Q.offer(s1);
            Q.offer(s2);
            Q.offer(s3);
            Q.offer(s4);

        } else {
            di = new int[]{1, 0, -1, 0, 1, 0, -1, 0};
            dj = new int[]{0, 1, 0, -1, 0, 1, 0, -1};

            Q.offer(s1);
            Q.offer(s4);
            Q.offer(s3);
            Q.offer(s2);
        }

        map[s1[0]][s1[1]] = 1;
        map[s2[0]][s2[1]] = 1;
        map[s3[0]][s3[1]] = 1;
        map[s4[0]][s4[1]] = 1;
        check[s1[0]][s1[1]] = 1;
        check[s2[0]][s2[1]] = 1;
        check[s3[0]][s3[1]] = 1;
        check[s4[0]][s4[1]] = 1;

        int idx = 0;
        while (!Q.isEmpty()) {

            Integer[] current = Q.poll();
            idx = idx % 4;

            for (int i = idx; i < 8; i++) {
                int next_i = current[0] + di[i];
                int next_j = current[1] + dj[i];

                if (next_i < 0 || next_i >= n || next_j < 0 || next_j >= n) continue;
                if (check[next_i][next_j] == 1) continue;

                check[next_i][next_j] = 1;
                map[next_i][next_j] = map[current[0]][current[1]] + 1;
                Q.offer(new Integer[]{next_i, next_j});
                idx++;
                break;
            }
        }

        return map;
    }


    public static void main(String[] args) {

        B b = new B();

        int n = 6;
        boolean clockwise = false;

        b.solution(n, clockwise);
    }
}
