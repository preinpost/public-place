package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 아기 상어
 */
public class B16236 {

    /**
     * 아기상어의 시작 크기 : 2
     *
     * 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고
     *
     * 0: 빈 칸
     * 1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
     * 9: 아기 상어의 위치
     */
    static int[] di = new int[] {-1, 0, 1, 0}; // 위쪽이 우선, 차순위로 왼쪽
    static int[] dj = new int[] {0, -1, 0, 1};

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.first == this.first) return this.second - o.second;
            return this.first - o.first;

        }
    }

    int weight = 2;
    int eatCount = 0;
    int[][] map;
    Pair startPos = null;

    public static void main(String[] args) throws IOException {
        B16236 T = new B16236();
        int answer = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        T.map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            StringTokenizer st = new StringTokenizer(s);

            int j = 0;
            while (st.hasMoreTokens()) {
                String nextToken = st.nextToken();

                if (nextToken.equals("9")) {
                    T.startPos = new Pair(i, j);
                    T.map[i][j++] = 0;
                    continue;
                }

                T.map[i][j++] = Integer.parseInt(nextToken);
            }
        }

        int result = 0;
        do {
            // 다음 먹을 물고기 찾기
            int[][] checkMap = new int[n][n];
            result = T.searchFish(checkMap, n);
            answer += result;

        } while (result != 0);

        System.out.println(answer);


    }

    public int searchFish(int[][] checkMap, int n) {
        Queue<Pair> Q = new LinkedList<>();
        Q.offer(startPos);
        checkMap[startPos.first][startPos.second] = 1;
        int searchCount = 0;
        boolean isFound = false;
        List<Pair> candid = new ArrayList<>();

        while (!Q.isEmpty()) {
            int size = Q.size();
            searchCount++;

            for (int i = 0; i < size; i++) {
                Pair poll = Q.poll();

                for (int j = 0; j < 4; j++) {
                    int next_i = poll.first + di[j];
                    int next_j = poll.second + dj[j];

                    if (!isValidBoundary(next_i, next_j, n)) continue;
                    if (isChecked(next_i, next_j, checkMap)) continue;
                    if (isBigFish(next_i, next_j)) continue;

                    checkMap[next_i][next_j] = 1;
                    Q.offer(new Pair(next_i, next_j));

                    if (map[next_i][next_j] != 0 && weight > map[next_i][next_j]) {
                        isFound = true;
                        candid.add(new Pair(next_i, next_j));
                    }
                }
            }

            if (isFound) {
                eatCount++;
                if (weight == eatCount) {
                    weight++;
                    eatCount = 0;
                }

                Collections.sort(candid);

                map[candid.get(0).first][candid.get(0).second] = 0;
                startPos.first = candid.get(0).first;
                startPos.second = candid.get(0).second;

                return searchCount;
            }
        }
        return 0;
    }

    public boolean isValidBoundary(int next_i, int next_j, int n) {
        return next_i >= 0 && next_j >= 0 && next_i < n && next_j < n;
    }

    public boolean isBigFish(int next_i, int next_j) {
        return map[next_i][next_j] > weight;
    }

    public boolean isChecked(int next_i, int next_j, int[][] checkMap) {
        return checkMap[next_i][next_j] == 1;
    }
}
