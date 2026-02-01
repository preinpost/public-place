package baek;

import java.util.Scanner;

public class B10870 {

    public static void main(String[] args) {

        B10870 b10870 = new B10870();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        System.out.println(b10870.DFS(n));
    }

    public int DFS(int n) {
        if (n == 0) return 0;

        if (n == 1 || n == 2) return 1;

        return DFS(n - 2) + DFS(n - 1);
    }
}
