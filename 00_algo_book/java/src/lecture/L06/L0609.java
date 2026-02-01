package lecture.L06;

import java.util.Scanner;

public class L0609 {

    public void solution(int n, int m, int[] arr) {

        int answer = 0;
        int minRange = Integer.MIN_VALUE;
        int maxRange = 0;
        for (int x : arr) {
            minRange = Math.max(x, minRange);
            maxRange += x;
        }

        int[] array = new int[n+1];

        System.arraycopy(arr, 0, array, 0, n+1);

        while (minRange <= maxRange) {

            int sum = 0;
            int group = 0;
            int mid = (minRange + maxRange) / 2;

            for (int i = 0; i < n; i++) {

                sum += array[i];

                if (sum + array[i+1] > mid) {
                    group++;
                    sum = 0;
                }
            }

            if (sum != 0) {
                group++;
            }

            if (group <= m) {
                // 왼쪽으로 이동
                answer = mid;
                maxRange = mid - 1;

            } else {
                // 오른쪽으로 이동
                minRange = mid + 1;

            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {

        L0609 T = new L0609();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n+1];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        T.solution(n, m, arr);
    }
}
