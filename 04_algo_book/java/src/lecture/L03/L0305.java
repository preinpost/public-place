package lecture.L03;

import java.util.Scanner;

public class L0305 {

    public void solution(int n) {

        int[] arr = new int[n];

        for (int i = 1; i < n+1; i++) {
            arr[i-1] = i;
        }

        int p1 = 0;
        int p2 = 0;
        int answer = 0;
        int sum = 0;

        while (p1 < n-1) {

            while (sum < n) {
                sum += arr[p2];
                p2++;
            }

            if (sum == n) {
                answer++;
            }

            sum -= arr[p1];
            p1++;

        }

        System.out.println(answer);

    }

    public static void main(String[] args) {

        L0305 T = new L0305();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        T.solution(n);
    }

}
