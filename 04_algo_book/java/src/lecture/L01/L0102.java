package lecture.L01;

import java.util.Scanner;

public class L0102 {
    public String solution(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if (Character.isLowerCase(x)) {
                answer+=Character.toUpperCase(x);
            } else { // ASCII 값으로 대문자는 65 ~ 90 소문자는 97 ~ 122
                answer+=Character.toLowerCase(x);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        L0102 T = new L0102();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }

}
