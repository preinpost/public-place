package lecture.L08;

import java.util.Scanner;

public class L0809 {

    static int[] chk;
    static int[] answer;

    public void solution(int n, int m) {

        DFS(0, 1, n, m);

    }

    public void DFS(int level, int start, int n, int m) {
        if (level == m) {

            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();

            return;
        }

        for (int i = start; i <= n; i++) {
            if (chk[i] == 1) continue;

            chk[i] = 1;
            answer[level] = i;
            DFS(level+1, start+i, n, m);
            chk[i] = 0;
        }

    }

    public static void main(String[] args) {

        L0809 T = new L0809();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        chk = new int[n+1];
        answer = new int[m];

        T.solution(n, m);
    }
}
