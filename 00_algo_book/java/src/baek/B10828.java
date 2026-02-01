package baek;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int lineNum = Integer.parseInt(s);
        int ptr = -1;
        int[] stack = new int[10000];
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < lineNum; i++) {
            s = bf.readLine();
            String[] line = s.split(" ");
            String command = line[0];
            int x = 0;
            if (line.length > 1) {
                x = Integer.parseInt(line[1]);
            }

            if ("push".equals(command)) {
                ptr += 1;
                stack[ptr] = x;

            } else if ("pop".equals(command)) {
                if (ptr == -1) {
                    answer.append(-1);
                } else {
                    answer.append(stack[ptr]);
                    ptr -= 1;
                }
                answer.append("\n");

            } else if ("size".equals(command)) {
                answer.append(ptr + 1);
                answer.append("\n");
            } else if ("empty".equals(command)) {
                if (ptr == -1) {
                    answer.append(1);
                } else {
                    answer.append(0);
                }
                answer.append("\n");

            } else if ("top".equals(command)) {
                if (ptr == -1) {
                    answer.append(-1);
                } else {
                    answer.append(stack[ptr]);
                }
                answer.append("\n");
            }
        }

        System.out.println(answer);
    }
}
