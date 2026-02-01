package lecture.L02;

import java.util.Scanner;

public class L0209 {

    public void solution(int n, int[][] arr) {
        int max = 0;
        int sum1, sum2;

        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
        }

        sum1 = sum2 = 0;
        // 대각선 우하향
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[n-i-1][n-i-1];
        }

        max = Math.max(max, sum1);
        max = Math.max(max, sum2);

        System.out.println(max);


    }

    public static void main(String[] args) {
        L0209 T = new L0209();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                int num = in.nextInt();
                arr[i][j] = num;

            }
        }

        T.solution(n, arr);

    }
}
