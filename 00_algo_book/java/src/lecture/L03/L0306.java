package lecture.L03;

import java.util.Scanner;

public class L0306 {

    public void solution(int n, int k, int[] arr) {

        int p1 = 0;
        int p2 = 0;
        int max = 0;
        int zero_cnt = 0;

        while (p1 < n) {

            while (zero_cnt < k+1 && p2 < n) {
                if (arr[p2] == 0) zero_cnt++;
                p2++;
            }

            max = Math.max(max, p2-p1-1);

            if (arr[p1] == 0) zero_cnt--;
            p1++;

        }

        System.out.println(max);
    }

    public static void main(String[] args) {

        L0306 T = new L0306();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] arr = new int[n+1];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        arr[n] = -1;

        T.solution(n, k, arr);
    }
}
