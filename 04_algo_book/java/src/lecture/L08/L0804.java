package lecture.L08;

import java.util.Scanner;

public class L0804 {

    static int[] arr;

    public void solution(int n, int m) {

        DFS(0, n, m);

    }

    public void DFS(int L, int n, int m) {

        if (L == m) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[L] = i;
            DFS(L+1, n, m);
        }

    }

    public static void main(String[] args) {

        L0804 T = new L0804();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        arr = new int[m];

        T.solution(n, m);
    }
}
