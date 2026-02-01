package lecture.L10;

import java.util.Scanner;

public class L1001 {

    static int[] dy;

    public void solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <=n; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }

        System.out.println(dy[n]);
    }

    public static void main(String[] args) {

        L1001 T = new L1001();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        dy = new int[n+1];

        T.solution(n);
    }
}
