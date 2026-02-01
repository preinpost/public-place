package lecture.L09;

import java.util.Scanner;

public class L0906 {

    static int[] unf;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        unf = new int[n+1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            Union(a, b);
        }
        int a = in.nextInt();
        int b = in.nextInt();
        int fa = Find(a);
        int fb = Find(b);

        if (fa == fb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa!=fb) unf[fa] = fb;
    }

    private static int Find(int v) {
        if (v==unf[v]) return v;
        else return unf[v]=Find(unf[v]);
    }
}
