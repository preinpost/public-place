package lecture.L10;

import java.util.Scanner;

public class L1002 {

    static int[] cache;

    public void solution(int n) {

        cache[1] = 1;
        cache[2] = 2;

        for (int i = 3; i <= n+1; i++) {
            cache[i] = cache[i-2] + cache[i-1];
        }

        System.out.println(cache[n+1]);
    }

    public static void main(String[] args) {

        L1002 T = new L1002();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        cache = new int[n+2];

        T.solution(n);
    }
}
