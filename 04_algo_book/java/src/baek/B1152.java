package baek;

import java.util.Scanner;

public class B1152 {

    public void solution(String str) {

        if (str.startsWith(" ")) {
            if (str.length() == 1) {
                System.out.println(0);
                return;
            }

            str = str.substring(1);
        }
        if (str.endsWith(" ")) {
            str = str.substring(0, str.length() - 1);
        }

        String[] s = str.split(" ");
        System.out.println(s.length);

    }

    public static void main(String[] args) {
        B1152 T = new B1152();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        T.solution(str);

    }
}