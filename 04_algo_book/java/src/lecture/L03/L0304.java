package lecture.L03;

import java.util.Scanner;

public class L0304 {

    public void solution(int n, int m, int[] arr) {

        int p1 = 0;
        int answer = 0;

        while (p1 < n) {
            int p2 = p1;
            int sum = 0;

            while (p2 < n) {
                sum += arr[p2];
                p2++;

                if (sum == m) {
                    answer++;
                } else if(sum > m) {
                    break;
                }
            }
            p1++;
        }

        System.out.println(answer);

    }

    public static void main(String[] args) {
        L0304 T = new L0304();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        T.solution(n, m, arr);
    }
}
