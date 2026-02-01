package baek;

import java.util.Scanner;

public class B2003 {

    public void solution(int n, int m, int[] arr) {
        // n : 숫자의 개수
        // m : 나와야 하는 값

        int p1 = 0;
        int answer = 0;

        while (p1 < n) {

            int sum = 0;
            int currentA = arr[p1];
            int p2 = p1 + 1;

            sum += currentA;

            if (sum > m) {
                p1++;
                continue;
            }
            else if (sum == m) {
                p1++;
                answer++;
                continue;
            }

            while (p2 < n) {
                int currentB = arr[p2];

                sum+= currentB;

                if (sum > m) {
                    p2++;
                    break;
                }
                else if (sum == m) {
                    p2++;
                    answer++;
                    break;
                }

                p2++;
            }
            p1++;
        }

        System.out.println(answer);
    }


    public static void main(String[] args) {
        B2003 T = new B2003();

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
