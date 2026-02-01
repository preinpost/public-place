package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 후위 표기식
public class B1918 {

    public static void main(String[] args) throws IOException {
        B1918 b1918 = new B1918();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        b1918.solution(s);
    }

    public void solution(String s) {
        Stack<Character> stk = new Stack<>();
        StringBuffer sb = new StringBuffer();
        Map<Character, Integer> valueMap = new HashMap<>();

        valueMap.put('*', 1);
        valueMap.put('/', 1);
        valueMap.put('+', 0);
        valueMap.put('-', 0);
        valueMap.put('(', -1);

        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);

            if (currentChar.toString().matches("[A-Z]")) {
                sb.append(currentChar);
                continue;
            }

            if (currentChar == '(') {
                stk.push(currentChar);
                continue;
            }

            if (currentChar == ')') {
                while (stk.peek() != '(') {
                    sb.append(stk.pop());
                }
                stk.pop();
                continue;
            }

            if (stk.size() > 0) {
                int size = stk.size();

                for (int j = 0; j < size; j++) {
                    Integer currentTopValue = valueMap.get(stk.peek());
                    Integer currentInputValue = valueMap.get(currentChar);

                    if (currentTopValue >= currentInputValue) {
                        sb.append(stk.pop());
                    } else break;
                }
            }

            if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                stk.push(currentChar);
            }
        }

        while (!stk.isEmpty()) sb.append(stk.pop());

        System.out.println(sb);
    }
}
