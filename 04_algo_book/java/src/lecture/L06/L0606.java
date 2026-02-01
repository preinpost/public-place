package lecture.L06;

import java.util.Arrays;
import java.util.Scanner;

public class L0606 {

    public void solution(int n, int[] arr) {

        int[] copy = new int[n];

        System.arraycopy(arr, 0, copy, 0, n);

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (copy[i] != arr[i]) {
                System.out.print(i+1 + " ");
            }
        }

    }

    public static void main(String[] args) {

        L0606 T = new L0606();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        T.solution(n, arr);
    }
}
