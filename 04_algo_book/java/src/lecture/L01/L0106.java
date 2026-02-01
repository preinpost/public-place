package lecture.L01;

import java.util.Scanner;

public class L0106 {

    public String solution(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            // System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
            if (str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        L0106 T =new L0106();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(T.solution(str));

    }
}
