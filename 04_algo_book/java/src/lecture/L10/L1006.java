package lecture.L10;

import java.util.*;

public class L1006 {

    static int[] dp;

    static class Problem {
        int score;
        int time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public void solution(int n, int m, List<Problem> arr) {

        for (int i = 0; i < n; i++) {
            Problem curremtProblem = arr.get(i);

            for (int j = m; j >= curremtProblem.time; j--) {
                dp[j] = Math.max(dp[j], dp[j-curremtProblem.time] + curremtProblem.score);
            }
        }
        System.out.println(dp[m]);
    }

    public static void main(String[] args) {

        L1006 T = new L1006();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        dp = new int[m+1];

        List<Problem> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
           arr.add(new Problem(in.nextInt(), in.nextInt()));

        }

        T.solution(n, m, arr);
    }
}
