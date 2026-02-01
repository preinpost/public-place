package lecture.L02;

import java.util.Scanner;

public class L0208 {

    public void solution(int n, int[] list) {

        for (int i = 0; i < n; i++) {
            int current = list[i];
            int rank = 0;

            for (int j = 0; j < n; j++) {

                if (i == j) {
                    continue;
                }
                int comparing = list[j];

                if (comparing > current) {
                    rank++;
                }
            }
            System.out.print((rank + 1) + " ");
        }
    }

    public static void main(String[] args) {
        L0208 T = new L0208();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = in.nextInt();
        }

        T.solution(n, list);

    }
}
