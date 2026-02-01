package lecture.L08;

import java.util.Scanner;

public class L0802 {

    public void solution(int c, int n, int[] arr) {

        int dfs = DFS(0, 0, 0, n, c, arr);
        System.out.println(dfs);
    }

    public int DFS(int level, int sum, int max, int n, int c, int[] arr) {
        if (sum > c) return 0;
        if (level == n) {
            return sum;

        } else {
            sum += arr[level];
            max = Math.max(max, DFS(level + 1, sum, max, n, c, arr));

            sum -= arr[level];
            max = Math.max(max, DFS(level + 1, sum, max, n, c, arr));
        }
        return max;
    }

    public static void main(String[] args) {

        L0802 T = new L0802();

        Scanner in = new Scanner(System.in);

        int c = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        T.solution(c, n, arr);

    }
}
