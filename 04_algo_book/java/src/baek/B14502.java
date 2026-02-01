package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 연구소
public class B14502 {

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int[] di = {0, -1, 0, 1};
    static int[] dj = {1, 0, -1, 0};

    int n, m;
    int[][] arr;
    int answer = Integer.MIN_VALUE;
    List<Pair> virus = new ArrayList<>();
    List<Pair> empty = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        B14502 T = new B14502();

        T.input();
        T.combination(0, 0, 3, new int[3], T.empty);
        System.out.println(T.answer);
    }

    private void input() throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);

            for (int j = 0; j < m; j++) {
                int current = Integer.parseInt(st.nextToken());

                if (current == 0) empty.add(new Pair(i, j));
                else if (current == 2) virus.add(new Pair(i, j));

                arr[i][j] = current;
            }
        }
    }

    private int simulation(int i, int j, int[][] check, int cnt) {
        if (!isValidBoundary(i, j)) return cnt;

        for (int k = 0; k < 4; k++) {
            int nextI = i + di[k];
            int nextJ = j + dj[k];

            if (!isValidBoundary(nextI, nextJ)) continue;
            if (arr[nextI][nextJ] == 1 || arr[nextI][nextJ] == 2) continue;
            if (isVisited(nextI, nextJ, check)) continue;

            check[nextI][nextJ] = 1;
            cnt += 1;
            cnt = simulation(nextI, nextJ, check, cnt);
        }

        return cnt;
    }

    private void combination(int depth, int s, int r, int[] candid, List<Pair> list) {
        if (depth == r) {
            arr[list.get(candid[0]).first][list.get(candid[0]).second] = 1;
            arr[list.get(candid[1]).first][list.get(candid[1]).second] = 1;
            arr[list.get(candid[2]).first][list.get(candid[2]).second] = 1;

            int[][] check = new int[n][m];
            int cnt = 0;
            for (int i = 0; i < virus.size(); i++) {
                Pair poll = virus.get(i);
                cnt += simulation(poll.first, poll.second, check, 0);
            }

            answer = Math.max(answer, empty.size() - cnt - 3);

            arr[list.get(candid[0]).first][list.get(candid[0]).second] = 0;
            arr[list.get(candid[1]).first][list.get(candid[1]).second] = 0;
            arr[list.get(candid[2]).first][list.get(candid[2]).second] = 0;

            return;
        }

        for (int i = s; i < list.size(); i++) {
            candid[depth] = i;
            combination(depth + 1, i + 1, r, candid, list);
        }
    }

    public boolean isValidBoundary(int i, int j) {
        return i >=0 && j>=0 && i < n && j < m;
    }

    public boolean isVisited(int i, int j, int[][] check) {
        return check[i][j] == 1;
    }
}
