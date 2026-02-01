package lecture.L04;

import java.util.*;

public class L0405 {

    public void solution(int n, int k, int[] arr) {

        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int l = j+1; l < n; l++) {
                    tSet.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        if (tSet.toArray().length < k) {
            System.out.println(-1);
            return;
        }

        System.out.print(tSet.toArray()[k-1]);

    }

    public static void main(String[] args) {

        L0405 T = new L0405();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        T.solution(n, k, arr);
    }
}
