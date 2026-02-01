package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 잃어버린 괄호
public class B1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stk = new Stack<>();

        String s = bf.readLine();

        int p1 = 0, p2 = 1;

        while (true) {
            if (p2 > s.length() - 1) {
                stk.push(s.substring(p1));
                break;
            }

            if (s.charAt(p2) == '+' || s.charAt(p2) == '-') {
                stk.push(s.substring(p1, p2));
                stk.push(s.substring(p2, p2 + 1));

                p1 = p2 + 1;
                p2 = p2 + 1;
            }
            p2++;
        }

        int sum = 0;
        int minusSum = 0;

        if (stk.size() == 1) {
            System.out.println(stk.pop());
            return;
        }

        while (!stk.isEmpty()) {
            String second = stk.pop();
            String op = stk.pop();
            String first = stk.pop();

            if (op.equals("-")) {
                minusSum += Integer.parseInt(second);
                stk.push(first);
            } else {
                stk.push(String.valueOf(Integer.parseInt(first) + Integer.parseInt(second)));
            }

            if (stk.size() == 1) {
                sum += Integer.parseInt(stk.pop());
                break;
            }
        }

        System.out.println(sum - minusSum);
    }
}
