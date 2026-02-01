package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토
 */
public class B7569 {

    static class Pair {
        int first;
        int second;
        int third;

        public Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    static int[] di = new int[]{-1, 1, 0, 0, 0, 0}; // 높이
    static int[] dj = new int[]{0, 0, -1, 1, 0, 0}; // 세로
    static int[] dk = new int[]{0, 0, 0, 0, 1, -1}; // 가로

    int M;
    int N;
    int H;

    int[][][] map;
    int[][][] check;
    int count = 0;
    int maxCount;

    public static void main(String[] args) throws IOException {
        B7569 T = new B7569();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        String[] split = s.split(" ");

        T.M = Integer.parseInt(split[0]); // 가로
        T.N = Integer.parseInt(split[1]); // 세로
        T.H = Integer.parseInt(split[2]); // 높이

        T.map = new int[T.H][T.N][T.M]; // 높이, 세로, 가로
        T.check = new int[T.H][T.N][T.M];

        Queue<Pair> Q = new LinkedList<>();

        for (int i = 0; i < T.H; i++) {
            for (int j = 0; j < T.N; j++) {
                String line = bf.readLine();
                StringTokenizer st = new StringTokenizer(line);

                for (int k = 0; k < T.M; k++) {
                    String next = st.nextToken();
                    if (next.equals("1")) {
                        Q.offer(new Pair(i, j, k));
                        T.check[i][j][k] = 1;
                        T.count++;
                    } else if (next.equals("-1")) {
                        T.maxCount--;
                    }
                    T.map[i][j][k] = Integer.parseInt(next);
                }
            }
        }

        T.maxCount = T.M * T.N * T.H + T.maxCount;

        int answer = T.run(Q);
        System.out.println(answer);
    }

    public int run(Queue<Pair> Q) {
        if (maxCount == count) return 0;

        int answer = -1;

        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {

                Pair poll = Q.poll();

                for (int j = 0; j < 6; j++) {
                    int nextI = poll.first + di[j];
                    int nextJ = poll.second + dj[j];
                    int nextK = poll.third + dk[j];

                    if(isBoundary(nextI, nextJ, nextK)) continue;
                    if (isWall(nextI, nextJ, nextK)) continue;
                    if (isAgain(nextI, nextJ, nextK)) continue;

                    check[nextI][nextJ][nextK] = 1;

                    if (map[nextI][nextJ][nextK] == 0) {
                        count++;
                        map[nextI][nextJ][nextK] = 1;
                    }

                    Q.offer(new Pair(nextI, nextJ, nextK));
                }

            }
            answer++;
        }

        if (maxCount == count) {
            return answer;
        }

        return -1;
    }

    public boolean isBoundary(int ni, int nj, int nk) {
        if (ni < 0 || nj < 0 || nk < 0 || ni >= H || nj >= N || nk >= M ) return true;
        return false;
    }

    public boolean isWall(int ni, int nj, int nk) {
        if (map[ni][nj][nk] == -1) return true;
        return false;
    }

    public boolean isAgain(int ni, int nj, int nk) {
        if (check[ni][nj][nk] == 1) return true;
        return false;
    }
}
