package lecture.L03;

import java.util.Scanner;

public class L0301 {

    public void solution(int n, int m, int[] arr1, int[] arr2) {
        int[] newArr = new int[n+m];

        int pnt = 0;
        int i = 0;
        int j = 0;

        while (pnt < n + m) {

            if (arr1[i] < arr2[j]) {
                newArr[pnt] = arr1[i];
                i++;
            }
            else if (arr1[i] >= arr2[j]) {
                newArr[pnt] = arr2[j];
                j++;
            }
            pnt++;

            if (i == n) {
                for (int k = j; k < m; k++) {
                    newArr[pnt] = arr2[k];
                    pnt++;
                }
                break;
            } else if (j == m) {
                for (int k = i; k < n; k++) {
                    newArr[pnt] = arr1[k];
                    pnt++;
                }
                break;
            }

        }

        for (int i1 : newArr) {
            System.out.print(i1 + " ");
        }


    }

    public static void main(String[] args) {
        L0301 T = new L0301();

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
