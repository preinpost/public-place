package lecture.L10;

import java.util.Arrays;
import java.util.Scanner;

public class L1005 {

    int[] dy;

    public void solution(int n, int[] arr, int m) {
        dy = new int[m+1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            for (int j = curr; j < m+1; j++) {
                dy[j] = Math.min(dy[j], dy[j-curr] + 1);
            }
        }
        System.out.println(dy[m]);
    }

    public static void main(String[] args) {

        L1005 T = new L1005();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int m = in.nextInt();

        T.solution(n, arr, m);
    }
}
