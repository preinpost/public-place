package lecture.L05;

import java.util.ArrayList;
import java.util.Scanner;

public class L0501_oneStack {

    public String solution(String str) {

        ArrayList<Character> stk = new ArrayList<>();

        for (char c : str.toCharArray()) {
            if (c == '(') stk.add(c);
            else {
                if (stk.size() == 0) return "NO";

                stk.remove(stk.size()-1);
            }
        }

        if (stk.size() > 0) return "NO";

        return "YES";

    }

    public static void main(String[] args) {

        L0501_oneStack T = new L0501_oneStack();

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(T.solution(str));
    }
}
