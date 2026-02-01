package lecture.L05;

import java.util.ArrayList;
import java.util.Scanner;

public class L0501 {

    public String solution(String str) {

        ArrayList<Character> stk1 = new ArrayList<>(); // ( 저장
        ArrayList<Character> stk2 = new ArrayList<>(); // ) 저장

        if (str.charAt(str.length()-1) != ')') return "NO";

        for (char c : str.toCharArray()) {
            if (c == ')') {
                stk2.add(c);
            } else {
                stk1.add(c);
            }
        }

        if (stk1.size() == stk2.size()) return "YES";
        else return "NO";

    }

    public static void main(String[] args) {

        L0501 T = new L0501();

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(T.solution(str));
    }
}
