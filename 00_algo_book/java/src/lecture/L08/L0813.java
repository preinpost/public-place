package lecture.L08;

import java.util.Scanner;

public class L0813 {

    static int[] di = {1, 0, -1, 0, 1, -1, 1, -1};
    static int[] dj = {0, 1, 0, -1, 1, -1, -1, 1};
    static boolean flag = false;
    static int answer = 0;

    public void solution(int n, int[][] arr) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flag = false;
                DFS(i, j, n, arr);
                if (flag) answer++;
            }
        }

        System.out.println(answer);

    }

    public void DFS(int i, int j, int n, int[][] arr) {
        if (i < 0 || j < 0 || i >= n || j >= n) return;
        if (arr[i][j] == 0) return;

        arr[i][j] = 0;
        flag = true;

        for (int k = 0; k < 8; k++) {
            DFS(i+di[k], j+dj[k], n, arr);
        }
    }

    public static void main(String[] args) {

        L0813 T = new L0813();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int [][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        T.solution(n, arr);
    }
}
