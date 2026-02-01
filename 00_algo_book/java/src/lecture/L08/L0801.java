package lecture.L08;

import java.util.Scanner;

public class L0801 {

    static int n;
    static int[] chk;
    static String answer = "NO";

    public void solution(int n, int[] elem) {

        DFS(elem, 0);
    }

    public void DFS(int[] elem, int pointer) {

        if (pointer >= n) {
            int sum1 = 0;
            int sum0 = 0;

            for (int i : elem) {
                if (chk[i] == 1) {
                    sum1 += i;
                } else {
                    sum0 += i;
                }
            }

            if (sum0 == sum1) answer = "YES";

        } else {
            int curr = elem[pointer];
            chk[curr] = 1;
            DFS(elem, pointer+1);
            chk[curr] = 0;
            DFS(elem, pointer+1);
        }

    }

    public static void main(String[] args) {

        L0801 T = new L0801();

        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        int elem[] = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            elem[i] = in.nextInt();
            max = Math.max(elem[i], max);
        }

        chk = new int[max+1];

        T.solution(n, elem);
        System.out.println(answer);
    }
}
