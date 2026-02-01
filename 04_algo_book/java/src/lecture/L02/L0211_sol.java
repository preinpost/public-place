package lecture.L02;

import java.util.Scanner;

public class L0211_sol {

    public void solution(int n, int[][] arr) {
        int max = Integer.MIN_VALUE;
        int stdNo = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        sum++;
                        break;
                    }
                }
            }
            if (max < sum) {
                max = sum;
                stdNo = i;
            }
        }
        System.out.println(stdNo);
    }

    public static void main(String[] args) {
        L0211_sol T = new L0211_sol();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[][] arr = new int[n+1][6];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        T.solution(n, arr);
    }
}
