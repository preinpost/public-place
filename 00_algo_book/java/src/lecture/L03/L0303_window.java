package lecture.L03;

import java.util.Scanner;

public class L0303_window {

    public void solution(int n, int k, int[] arr) {

        int p1 = k - 1;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int max = sum;

        while (p1 <= n - k) {
            sum += arr[++p1];
            sum -= arr[p1 - k];
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }

        public static void main(String[] args) {

            L0303_window T = new L0303_window();

            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int k = in.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            T.solution(n, k, arr);
    }
}
