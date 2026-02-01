package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 플로이드
public class B11404 {

    int[][] dp;

    public static void main(String[] args) throws IOException {
        B11404 T = new B11404();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(bf.readLine());
        Integer m = Integer.parseInt(bf.readLine());

        T.dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                T.dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            String s = bf.readLine();
            StringTokenizer st = new StringTokenizer(s);

            Integer start = Integer.parseInt(st.nextToken());
            Integer end = Integer.parseInt(st.nextToken());
            Integer cost = Integer.parseInt(st.nextToken());

            T.dp[start][end] = Math.min(T.dp[start][end], cost);
        }

        T.search(n);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.dp[i][j] == Integer.MAX_VALUE) T.dp[i][j] = 0;
                System.out.print(T.dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    void search(int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {

                    if (i == j || i == k || j == k) continue;
                    if (dp[i][k] == Integer.MAX_VALUE) continue;
                    if (dp[k][j] == Integer.MAX_VALUE) continue;

                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
    }
}
