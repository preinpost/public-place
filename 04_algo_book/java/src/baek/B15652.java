package baek;

import java.util.Scanner;

public class B15652 {

    static int[] answer;

    public static void main(String[] args) {
        B15652 b15652 = new B15652();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        answer = new int[m];

        b15652.solution(n, m);
    }

    public void solution(int n, int m) {
        dfs(0, 1, n, m);
    }

    public void dfs(int level, int start, int n, int m) {
        if (level >= m) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            answer[level] = i;
            dfs(level+1, i, n, m);
        }
    }
}
