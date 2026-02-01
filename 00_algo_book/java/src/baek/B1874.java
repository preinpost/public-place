package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        Stack<Integer> stk = new Stack<>();
        Queue<Integer> Q = new LinkedList<>();

        StringBuffer answer = new StringBuffer();

        for (int i = 0; i < n; i++) {
            Q.add(Integer.parseInt(bf.readLine()));
        }

        for (int i = 1; i <= n; i++) {

            stk.push(i);
            answer.append("+\n");

            while ((!Q.isEmpty() && !stk.isEmpty()) && (Q.peek().equals(stk.peek())) ) {
                answer.append("-\n");
                Q.poll();
                stk.pop();
            }
        }

        if (Q.isEmpty() && stk.isEmpty())
            System.out.println(answer);
        else
            System.out.println("NO");
    }
}
