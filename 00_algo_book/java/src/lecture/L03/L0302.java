package lecture.L03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class L0302 {

    public void solution(int n, int m, int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList();

        int p1 = 0;
        int p2 = 0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) {
                p1++;
            } else if (arr1[p1] > arr2[p2]) {
                p2++;
            } else {
                answer.add(arr1[p1]);
                p1++;
                p2++;
            }
        }

        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }
    }

    public static void main(String[] args) {
        L0302 T = new L0302();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] arr2 = new int[m];

        for (int i = 0; i < m; i++) {
            arr2[i] = in.nextInt();
        }

        T.solution(n, m, arr1, arr2);

    }
}
