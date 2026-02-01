package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1012 {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) {

        B1012 b1012 = new B1012();

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int m = in.nextInt(); // 가로길이 (j)
            int n = in.nextInt(); // 세로길이 (i)
            int k = in.nextInt();

            int[][] map = new int[n][m];

            for (int j = 0; j < k; j++) {
                int a = in.nextInt(); // X
                int b = in.nextInt(); // Y

                map[b][a] = 1;
            }
            System.out.println(b1012.solution(m, n, map));
        }

    }

    private int solution(int m, int n, int[][] map) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) continue;
                bfs(j, i, m, n, map);
                answer++;
            }
        }
        return answer;
    }

    public void bfs(int sX, int sY, int m, int n, int[][] map) {

        Queue<Pair> Q = new LinkedList<>();
        Pair sPair = new Pair(sX, sY);

        Q.offer(sPair);

        while (!Q.isEmpty()) {

            Pair poll = Q.poll();

            for (int i = 0; i < 4; i++) {
                int next_X = poll.first + dx[i];
                int next_Y = poll.second + dy[i];

                if (next_X < 0 || next_Y < 0 || next_X >= m || next_Y >= n || map[next_Y][next_X] == 0) continue;
                map[next_Y][next_X] = 0;
                Q.offer(new Pair(next_X, next_Y));
            }
        }
    }
}
