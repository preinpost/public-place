package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2178 {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class State {
        int[][] min;

        public State(int[][] min) {
            this.min = min;
        }
    }

    static int[] dx = new int[]{1, 0 , -1, 0};
    static int[] dy = new int[]{0, 1 , 0, -1};

    public static void main(String[] args) {
        B2178 b2178 = new B2178();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // i, 세로
        int m = in.nextInt(); // j, 가로

        in.nextLine();

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {

            String line = in.nextLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j) - 48;
            }

        }

        State state = new State(new int[n][m]);

        b2178.solution(n, m, state, map);
    }

    public void solution(int n, int m, State state, int[][] map) {
        bfs(n, m, state, map);
        System.out.println(state.min[n-1][m-1]);
    }

    public void bfs(int n, int m, State state, int[][] map) {

        Queue<Pair> Q = new LinkedList<>();

        Q.offer(new Pair(0, 0));
        map[0][0] = 0;
        state.min[0][0] = 1;

        while (!Q.isEmpty()) {

            Pair poll = Q.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = poll.second + dx[i];
                int next_y = poll.first + dy[i];

                if (next_x < 0 || next_y < 0 || next_y >= n || next_x >= m || map[next_y][next_x] == 0) continue;
                Q.offer(new Pair(next_y, next_x));
                map[next_y][next_x] = 0;

                state.min[next_y][next_x] = state.min[poll.first][poll.second] + 1;

                if (next_x == m-1 && next_y == n-1) return;
            }
        }
    }
}
