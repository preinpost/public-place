package baek;

import java.util.Scanner;

public class B1717 {

    static int[] unf;

    public static void main(String[] args) {

        B1717 T = new B1717();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        unf = new int[n+1];

        for (int i = 0; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int command = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();

            if (command == 0) {
                T.union(a, b);
            } else {
                int aa = T.find(a);
                int bb = T.find(b);

                if (aa == bb) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public int find(int v) {
        if (unf[v] == v) return v;
        return unf[v] = find(unf[v]);
    }

    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa > fb) unf[fa] = fb;
        else unf[fb] = fa;
    }
}
