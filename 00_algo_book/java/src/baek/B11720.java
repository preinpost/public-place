package baek;

import java.util.Scanner;

public class B11720 {

    public static void main(String[] args) {
        B11720 T = new B11720();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();

        T.solution(n, str);

    }

    private void solution(int n, String str) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            int v = Integer.parseInt(String.valueOf(c));
            answer += v;
        }

        System.out.println(answer);
    }
}
