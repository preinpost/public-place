package lecture.L02;

import java.util.Scanner;

public class L0202 {

    public static void main(String[] args) {
        L0202 T = new L0202();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] list = new int[n];
        in.nextLine();

        for (int i = 0; i< n; i++) {
            list[i] = in.nextInt();
        }

        int answer = T.solution(n, list);
        System.out.println(answer);
    }

    private int solution(int n, int[] list) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (list[i] > max) {
                max = list[i];
                answer++;
            }
        }

        return answer;
    }
}
