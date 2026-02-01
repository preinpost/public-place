package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 녹색 옷 입은 애가 젤다지?
public class B4485 {

    static class Tuple {
        int first;
        int second;
        int third;

        public Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        B4485 T = new B4485();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();

        int cnt = 0;
        while (true) {
            int n = Integer.parseInt(bf.readLine());

            if (n == 0) break;
            cnt += 1;

            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                String s = bf.readLine();
                StringTokenizer st = new StringTokenizer(s);

                int j = 0;
                while (st.hasMoreTokens()) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    j += 1;
                }
            }

            sb.append(String.format("Problem %d: %s", cnt, T.run(n, map)));
            sb.append("\n");
        }

        System.out.print(sb);
    }

    int run(int n, int[][] map) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((o1, o2) -> o1.third - o2.third);
        pq.offer(new Tuple(0, 0, map[0][0]));
        int[][] dij = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dij[i][j] = Integer.MAX_VALUE;
            }
        }

        dij[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Tuple poll = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nI = poll.first + di[i];
                int nJ = poll.second + dj[i];

                if (nI >= n || nJ >= n || nI < 0 || nJ < 0) continue;

                int nValue = map[nI][nJ];

                if (dij[nI][nJ] > dij[poll.first][poll.second] + nValue) {
                    dij[nI][nJ] = dij[poll.first][poll.second] + nValue;
                    pq.offer(new Tuple(nI, nJ, nValue));
                }
            }
        }

        return dij[n - 1][n - 1];
    }
}
