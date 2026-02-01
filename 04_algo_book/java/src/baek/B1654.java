package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long max = Integer.MIN_VALUE + 1;

        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(bf.readLine());
            max = Math.max(max, num);
            arr[i] = num;
        }

        long p1 = 1;
        long p2 = max;
        long mid;
        long answer = 0;

        while (p1 <= p2) {
            long sum = 0;
            mid = (p1 + p2) / 2;

            for (int i : arr) {
                sum += i / mid;
            }

            if (sum < n) {
                // p2를 줄여야한다.
                p2 = mid - 1;
            } else {
                // p1을 올려야한다.

                p1 = mid + 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}
