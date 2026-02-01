package lecture.L02;

import java.util.ArrayList;
import java.util.Scanner;

public class L0211 {

    public void solution(int n, int[][] arr) {
        int max = Integer.MIN_VALUE;
        int stdNum = 0;

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> sameList = new ArrayList<>();
            int sum = 0;

            for (int j = 0; j < 5; j++) {

                int current = arr[i][j];

                for (int k = 0; k < n; k++) {
                    if (i == k) continue;
                    if (current == arr[k][j]) {
                        if(!sameList.contains(k))
                            sameList.add(k);
                        sum++;
                    }
                }
            }

           if (max < sameList.size()) {
               max = sameList.size();
               stdNum = i + 1;
           }
        }

        System.out.println(stdNum);
    }


    public static void main(String[] args) {
        L0211 T = new L0211();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[][] arr = new int[n][5];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        T.solution(n, arr);
    }
}
