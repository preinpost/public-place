package lecture.L02;

import java.util.Scanner;

public class L0212 {

    public void solution(int n, int m, int[][] arr) {
        int answer = 0;
        int[][] possibleMap = new int[n+1][n+1];

        // n = 사람 수
        // m = 라운드 수

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j < n; j++) {

                for (int k = j + 1; k <= n; k++) {
                    possibleMap[arr[i][j]][arr[i][k]] += 1;
                }
            }
        }
        for (int[] ints : possibleMap) {
            for (int anInt : ints) {
                if (anInt == m) {
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }

    public static void main(String[] args) {
        L0212 T = new L0212();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] arr = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        T.solution(n, m, arr);
    }
}
