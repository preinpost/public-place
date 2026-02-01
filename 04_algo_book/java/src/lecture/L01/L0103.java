package lecture.L01;

import java.util.Scanner;

public class L0103 {

    public String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
//        String[] s = str.split(" ");
//        for (String x : s) {
//            int len = x.length();
//            if (len > m) {
//                m = len;
//                answer = x;
//            }
//        }

        // 마지막 단어에는 공백이 안들어가므로 이 루프안에 들어가지 못한다.
        // return 하기 전에 체크해줘야함.
        while ((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }

        if (str.length() > m) answer = str;
        return answer;
    }

    public static void main(String[] args) {
        L0103 T = new L0103();
        Scanner in = new Scanner(System.in);
        String str =in.nextLine();
        System.out.println(T.solution(str));
    }
}
