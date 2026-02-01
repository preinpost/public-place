package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 적록색약
 */
public class B10026 {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int[] di = {0, 0, 1, -1};
    static int[] dj = {1, -1, 0, 0};

    int n;
    char[][] normalMap;
    int[][] normalVisit;
    char[][] redGreenMap;
    int[][] redGreenVisit;

    public static void main(String[] args) throws IOException {

        B10026 T = new B10026();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T.n = Integer.parseInt(bf.readLine());

        T.normalMap = new char[T.n][T.n];
        T.normalVisit = new int[T.n][T.n];
        T.redGreenMap = new char[T.n][T.n];
        T.redGreenVisit = new int[T.n][T.n];

        for (int i = 0; i < T.n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < T.n; j++) {
                char current = line.charAt(j);
                T.normalMap[i][j] = current;

                if (current == 'R') {
                    T.redGreenMap[i][j] = 'G';
                } else {
                    T.redGreenMap[i][j] = current;
                }
            }
        }

        int[] result = T.search();
        System.out.printf("%d %d%n", result[0], result[1]);

    }

    public int[] search() {
        int normalCnt = 0;
        int redGreenCnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bfs(i, j, normalMap, normalVisit)) normalCnt++;
                if (bfs(i, j, redGreenMap ,redGreenVisit)) redGreenCnt++;
            }
        }

        return new int[]{normalCnt, redGreenCnt};
    }

    public boolean bfs(int i, int j, char[][] map, int[][] visitMap) {
        char initChar = map[i][j];

        if (isOutOfBoundary(i, j)) return false;
        if (isVisited(i, j, visitMap)) return false;

        Queue<Pair> Q = new LinkedList<>();
        Q.offer(new Pair(i, j));

        while (!Q.isEmpty()) {
            Pair poll = Q.poll();

            for (int k = 0; k < 4; k++) {
                int nI = poll.first + di[k];
                int nJ = poll.second + dj[k];

                if (isOutOfBoundary(nI, nJ)) continue;
                if (isVisited(nI, nJ, visitMap)) continue;

                if (map[nI][nJ] == initChar) {
                    visitMap[nI][nJ] = 1;
                    Q.offer(new Pair(nI, nJ));
                }
            }
        }

        return true;
    }

    public boolean isOutOfBoundary(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n) return true;
        return false;
    }

    public boolean isVisited(int i, int j, int[][] visitMap) {
        if (visitMap[i][j] == 1) return true;
        return false;
    }
}
