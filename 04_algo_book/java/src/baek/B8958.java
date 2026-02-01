package baek;

import java.util.Scanner;

public class B8958 {

    public void solution(String[] str) {

        for (String s : str) {
            char[] cList = s.toCharArray();
            int sequence = 1;
            int score = 0;

            for (char x : cList) {
                if (x == 'O') {
                    score += sequence;
                    sequence++;

                } else {
                    sequence = 1;
                }
            }

            System.out.println(score);
        }
    }

    public static void main(String[] args) {
        B8958 T = new B8958();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        String[] strList = new String[n];

        for (int i = 0; i < n; i++) {
            strList[i] = in.nextLine();
        }

        T.solution(strList);
    }
}
