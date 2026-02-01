package lecture.L01;

import java.util.Scanner;

public class L0109 {

    public int solution(String s) {
        String answer = "";
//        for (char x : s.toCharArray()) {
//            if (x>=48 && x<= 57) answer = answer * 10 + (x-48);
//        }

        for (char x : s.toCharArray()) {
            if (Character.isDigit(x)) answer += x;
        }

        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        L0109 T = new L0109();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(T.solution(str));

    }
}
