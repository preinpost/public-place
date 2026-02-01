package lecture.L02;

import java.util.Scanner;

public class L0204 {

    public int[] solution(int n) {

        int[] numList = new int[n];
        numList[0] = 1;
        numList[1] = 1;


        for (int i = 2; i < n; i++) {
            int sum = 0;

            sum = numList[i-2] + numList[i-1];
            numList[i] = sum;
        }

        return numList;
    }

    public static void main(String[] args) {
        L0204 T = new L0204();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int x : T.solution(n)) {
            System.out.print(x + " ");
        }

    }
}