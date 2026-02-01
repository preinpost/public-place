package baek;

import java.util.Scanner;

public class B15650 {

    static int[] answer;

    public static void main(String[] args) {
        B15650 b15650 = new B15650();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        answer = new int[m];

        b15650.solution(n, m);
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
            dfs(level+1, i+1, n, m);
        }
    }
}
