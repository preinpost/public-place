package lecture.L02;

import java.util.Scanner;

public class L0210 {

    public void solution(int n, int[][] arr) {
        int answer = 0;

        for (int i = 0; i < n+2; i ++) {
            for (int j = 0; j < n+2; j++) {
                if (arr[i][j] == 0) continue;
                int num = arr[i][j];
                // i-1 i+1 j-1 j+1
                if (arr[i-1][j] < num && arr[i+1][j] < num && arr[i][j-1] < num && arr[i][j+1] < num) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        L0210 T = new L0210();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        in.nextLine();

        int[][] arr = new int[n+2][n+2];

        for (int i = 0; i < n+2; i++) {
            for (int j = 0; j < n+2; j++) {
                if (i == 0 || j == 0 || i == n+1 || j == n+1) {
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = in.nextInt();
            }
        }

        T.solution(n, arr);
    }
}
