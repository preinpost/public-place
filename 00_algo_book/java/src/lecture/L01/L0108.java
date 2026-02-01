package lecture.L01;

import java.util.Scanner;

public class L0108 {

    public String solution(String s) {
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuffer(s).reverse().toString();
        if (s.equals(tmp)) answer = "YES";

        return answer;
    }

    public static void main(String[] args) {

        L0108 T = new L0108();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(T.solution(str));
    }
}
