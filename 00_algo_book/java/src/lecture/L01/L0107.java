package lecture.L01;

import java.util.Scanner;

public class L0107 {

    public String solution(String str) {
        String answer = "NO";
//        int len = str.length();
//        for (int i = 0; i<len/2; i++) {
//            if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(len-i-1))) return "NO";
//        }

        String tmp = new StringBuffer(str).reverse().toString();

        if (str.equalsIgnoreCase(tmp)) answer = "YES";

        return answer;
    }

    public static void main(String[] args) {
        L0107 T = new L0107();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(T.solution(str));
    }
}
