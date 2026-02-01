package lecture.L06;

import java.util.Scanner;

public class L0603 {

    public void solution(int n, int[] arr) {

        for (int i = 1; i < n; i++) {

            int tmp = arr[i];

            for (int j = i; j > 0; j--) {

                arr[j] = arr[j-1];

                if (arr[j] < tmp) {
                    arr[j] = tmp;
                    break;
                } else if (j == 1) {
                    arr[0] = tmp;
                }

            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        L0603 T = new L0603();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        T.solution(n, arr);
    }
}
