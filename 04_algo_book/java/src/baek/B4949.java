package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 균형잡힌 세상
 */
public class B4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer answer = new StringBuffer();

        String s;
        while (!(s = bf.readLine()).equals(".")) {
            Stack<Character> stk = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);

                switch (currentChar) {
                    case '(':
                    case '[':
                        stk.push(currentChar);
                        break;

                    case ')':
                        if (stk.isEmpty()) stk.push(currentChar);
                        else {
                            if (stk.peek() == '(') stk.pop();
                            else stk.push(currentChar);
                        }
                        break;

                    case ']':
                        if (stk.isEmpty()) stk.push(currentChar);
                        else {
                            if (stk.peek() == '[') stk.pop();
                            else stk.push(currentChar);
                        }
                        break;
                }
            }

            if (stk.isEmpty()) answer.append("yes").append("\n");
            else answer.append("no").append("\n");
        }
        System.out.println(answer);
    }
}
