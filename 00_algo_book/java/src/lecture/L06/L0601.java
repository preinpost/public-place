package lecture.L06;

import java.util.Scanner;

public class L0601 {

    public void solution(int n, int[] arr) {

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        L0601 T = new L0601();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        T.solution(n, arr);
    }
}
