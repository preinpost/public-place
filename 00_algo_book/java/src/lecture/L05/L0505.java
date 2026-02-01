package lecture.L05;

import java.util.Scanner;
import java.util.Stack;

public class L0505 {

    public void solution(String str) {

        Stack<Character> stk = new Stack<>();
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stk.push('(');
            } else {
                // ')' 일 때,
                if (str.charAt(i-1) == '(') {
                    stk.pop();
                    answer += stk.size();
                } else {
                    stk.pop();
                    answer++;
                }
            }
        }

        System.out.println(answer);


    }

    public static void main(String[] args) {

        L0505 T = new L0505();

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        T.solution(str);
    }
}
