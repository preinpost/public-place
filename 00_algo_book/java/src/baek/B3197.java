package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3197 {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};

    static int[][] check;
    static int[][] dynamic;
    static Pair duckPos = null;
    static Pair targetDuck = null;

    static Queue<Pair> waterQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        /*

            1. 매일 물 공간과 접촉한 모든 빙판 공간은 녹는다. (가로나 세로로 닿아 있는 부분만 녹음)
            2. 백조가 만날 수 있는지 매일 체크 해야함
            '.'은 물 공간, 'X'는 빙판 공간, 'L'은 백조가 있는 공간으로 나타낸다.

         */

        B3197 b3197 = new B3197();
        StringTokenizer st;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());

        int r = Integer.parseInt(st.nextToken()); // 행 i, y
        int c = Integer.parseInt(st.nextToken()); // 열 j, x

        char[][] map = new char[r][c];
        check = new int[r][c];
        dynamic = new int[r][c];

        for (int[] ints : dynamic) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        for (int i = 0; i < r; i++) {
            String s = bf.readLine();

            for (int j = 0; j < c; j++) {
                char currentChar = s.charAt(j);

                if (currentChar == 'L') {
                    if (duckPos == null) {
                        duckPos = new Pair(i, j);
                        dynamic[i][j] = 0;
                    }
                    else targetDuck = new Pair(i, j);

                    waterQueue.add(new Pair(i, j));

                } else if (currentChar == '.') waterQueue.add(new Pair(i, j));

                map[i][j] = currentChar;
            }
        }
        b3197.solution(map, r, c);
    }

    public void solution(char[][] map, int r, int c) {

        int day = 0;

        boolean result = false;
        Queue<Pair> candidQ = new LinkedList<>();
        candidQ.add(duckPos);

        while (true) {
            result = ducksHandler(candidQ, map, day);
            if (result == true) break;
            map = iceHandler(waterQueue, r, c, map);
            day++;
        }

        System.out.println(dynamic[targetDuck.first][targetDuck.second]);

    }

    public char[][] iceHandler(Queue<Pair> waterQueue, int bound_y, int bound_x, char[][] map) {

        int size = waterQueue.size();

        for (int i = 0; i < size; i++) {
            Pair poll = waterQueue.poll();

            for (int j = 0; j < 4; j++) {
                int next_y = dy[j] + poll.first;
                int next_x = dx[j] + poll.second;

                if (next_y < 0 || next_x < 0 || next_y >= bound_y || next_x >= bound_x || check[next_y][next_x] == 1) continue;

                if(map[next_y][next_x] == 'X') {
                    map[next_y][next_x] = '.';
                    waterQueue.add(new Pair(next_y, next_x)); // 얼음이였다가 물로된 좌표만 들어감
                }
            }
        }

        return map;
    }

    public boolean ducksHandler(Queue<Pair> candidQ, char[][] map, int day) {

        Queue<Pair> Q = new LinkedList<>(candidQ);
        candidQ.clear();

        int[][] iceChecker = new int[map.length][map[0].length];

        while (!Q.isEmpty()) {
            Pair poll = Q.poll();
            check[poll.first][poll.second] = 1;

            for (int i = 0; i < 4; i++) {
                int next_y = dy[i] + poll.first;
                int next_x = dx[i] + poll.second;

                if (next_y < 0 || next_x < 0 || next_y >= map.length || next_x >= map[0].length || check[next_y][next_x] == 1) continue;
                if (map[next_y][next_x] == 'X') {
                    if (iceChecker[next_y][next_x] == 0) {
                        candidQ.add(new Pair(next_y, next_x));
                        iceChecker[next_y][next_x] = 1;
                    }
                    continue;
                }

                if (next_y == targetDuck.first && next_x == targetDuck.second) {
                    dynamic[next_y][next_x] = day;
                    return true;
                }

                if (dynamic[next_y][next_x] > day) {
                    dynamic[next_y][next_x] = day;
                    Q.add(new Pair(next_y, next_x));
                }

            }
        }

        return false;
    }

}
