package lecture.L02;

import java.util.Scanner;

public class L0207 {

    public void solution(int[] list) {
        int answer = 0;
        int bonus = 1;

        for (int x : list) {
            if (x == 1) {
                answer += bonus;
                bonus++;
            } else {
                bonus = 1;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        L0207 T = new L0207();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = in.nextInt();
        }

        T.solution(list);

    }
}
