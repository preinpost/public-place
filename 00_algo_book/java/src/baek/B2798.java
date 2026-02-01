package baek;

import java.util.Scanner;

public class B2798 {

    static int[] combi;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {

        B2798 b2798 = new B2798();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] arr = new int[n];
        combi = new int[3];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        b2798.dfs(0, 0, m, arr);
        System.out.println(answer);
    }

    public void dfs(int L, int s, int m, int[] arr) {
        if (L == 3) {
            int sum = 0;
            for (int i : combi) {
                sum += i;
            }

            if (m < sum) return;
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = s; i < arr.length; i++) {
            combi[L] = arr[i];
            dfs(L+1, i+1, m, arr);
        }
    }
}
