package lecture.L08;

import java.util.Scanner;

public class L0803 {

    public void solution(int n, int m, int[][] arr) {

        Integer[] dfs = DFS(0, new Integer[]{0, 0, 0}, n, m, arr);

        System.out.println(dfs[2]);
    }

    public Integer[] DFS(int level, Integer[] state, int n, int m, int[][] arr) {
        // state[0] : 점수 합계
        // state[1] : 시간 합계
        // state[2] : 정답

        if (level == n) {
            return state;
        }

        Integer[] result;

        state[0] += arr[level][0];
        state[1] += arr[level][1];

        result = DFS(level + 1, state, n, m, arr);

        state = result;

        if (state[1] <= m) {
            state[2] = Math.max(state[2], result[0]);
        }

        state[0] -= arr[level][0];
        state[1] -= arr[level][1];

        result = DFS(level + 1, state, n, m, arr);

        state = result;

        if (state[1] <= m) {
            state[2] = Math.max(state[2], result[0]);
        }

        return state;
    }

    public static void main(String[] args) {

        L0803 T = new L0803();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt(); // 점수
            arr[i][1] = in.nextInt(); // 시간
        }

        T.solution(n, m, arr);
    }
}
