package lecture.L06;

import java.util.Arrays;
import java.util.Scanner;

public class L0608 {

    public void solution(int n, int m, int[] arr) {

        Arrays.sort(arr);

        int start = 0;
        int mid = arr.length/2;
        int last = arr.length-1;

        while (true) {

            if (mid == 0) {
                System.out.println("Not Found");
                break;
            }

            if (m < arr[mid]) {
                last = mid - 1;
                mid = (start + last) / 2;
            } else if (m > arr[mid]) {
                start = mid + 1;
                mid = (start + last) / 2;
            } else {
                System.out.println(mid + 1);
                break;
            }

        }

    }

    public static void main(String[] args) {

        L0608 T = new L0608();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr =new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        T.solution(n, m, arr);
    }
}
