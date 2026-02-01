package baek;

import java.util.Scanner;

public class B15651 {

    static int[] combi;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {

        B15651 b15651 = new B15651();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        combi = new int[m];

        b15651.solution(n, m);
        System.out.println(sb.toString());
    }

    public void solution(int n, int m) {
        dfs(0, n, m);
    }

    public void dfs(int level, int n, int m) {
        if (level >= m) {

            for (int i : combi) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            combi[level] = i;
            dfs(level+1, n, m);
            combi[level] = 0;
        }


    }
}
