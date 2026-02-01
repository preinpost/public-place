package baek;

import java.util.Scanner;

public class B1932 {

    static int[][] dp;
    static int answer = -1;

    public int solution(int n, int[][] map) {

        if (n == 1) {
            return map[0][0];
        }

        dp[0][0] = map[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {

                if (j == 0) {
                    dp[i][j] = dp[i-1][0] + map[i][0];
                } else if (j == i) {
                    dp[i][j] = dp[i-1][i-1] + map[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + map[i][j];
                }

                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        B1932 T = new B1932();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                map[i][j] = in.nextInt();
            }
        }
        System.out.println(T.solution(n, map));
    }
}
