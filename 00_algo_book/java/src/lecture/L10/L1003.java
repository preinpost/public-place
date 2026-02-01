package lecture.L10;

import java.util.Scanner;

public class L1003 {

    static int[] dy;

    public void solution(int n, int[] arr) {
        int answer = 0;
        dy[0] = 1;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > max) max = dy[j];
            }
            dy[i] = max+1;
        answer = Math.max(answer, dy[i]);
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {

        L1003 T = new L1003();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr =new int[n];
        dy = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        T.solution(n, arr);
    }
}
