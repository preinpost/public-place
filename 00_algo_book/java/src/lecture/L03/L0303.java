package lecture.L03;

import java.util.Scanner;

public class L0303 {

    public void solution(int n, int k, int[] arr) {

        // n : 일 수
        // k : 연속 일 수

        int p1 = 0;
        int max = Integer.MIN_VALUE;

        while (p1 <= n - k) {
            int p2 = p1;
            int sum = 0;
            int cnt = 0;

            while (cnt < k) {
                int currentB = arr[p2];

                sum += currentB;

                p2++;
                cnt++;
            }

            max = Math.max(max , sum);

            p1++;
        }

        System.out.println(max);


    }

    public static void main(String[] args) {
        L0303 T = new L0303();

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
