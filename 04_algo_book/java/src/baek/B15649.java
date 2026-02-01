package baek;

import java.util.Scanner;

public class B15649 {

    static int[] answer;
    static int[] chk;

    public static void main(String[] args) {

        B15649 b15649 = new B15649();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        answer = new int[m];
        chk = new int[n+1];

        b15649.solution(n, m);
    }

    public void solution(int n, int m) {

        dfs(0, n, m);
    }

    public void dfs(int level, int n, int m) {
        if (level >= m) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (chk[i] == 1) continue;
            answer[level] = i;
            chk[i] = 1;
            dfs(level+1, n, m);
            chk[i] = 0;
        }
    }
}
