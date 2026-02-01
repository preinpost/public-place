package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16637 {

    int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        B16637 b16637 = new B16637();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Integer length = Integer.parseInt(bf.readLine());
        String line = bf.readLine();

        b16637.solution(line);
    }

    public void solution(String line) {
        recursive(0, 0, line);

        System.out.println(max);
    }

    public void recursive(int idx, int sum, String line) {
        if (idx > line.length()-1) {
            max = Math.max(max, sum);
            return;
        }

        if (idx + 2 < line.length()) {

            if (idx == 0) {
                System.out.println(String.format("묶기 0일때 : %d, %d", getNumber(idx, line), getNumber(idx + 2, line)));
                sum = calculate(sum, calculate(getNumber(idx, line), getNumber(idx + 2, line), line.charAt(idx + 1)), '+');
                System.out.println("sum = " + sum);

            } else {
                System.out.println(String.format("묶기 0아님 : %d, %d", getNumber(idx, line), getNumber(idx + 2, line)));
                sum = calculate(sum, calculate(getNumber(idx, line), getNumber(idx + 2, line), line.charAt(idx + 1)), line.charAt(idx - 1));
                System.out.println("sum = " + sum);

            }
            recursive(idx+4, sum, line);
        }


        if (idx == 0) {
            System.out.println(String.format("하나씩 0일 때 : %d, %d", sum, getNumber(idx, line)));
            sum = calculate(sum, getNumber(idx, line), '+');
            System.out.println("sum = " + sum);

        } else {
            System.out.println(String.format("하나씩 0아님 : %d, %d", sum, getNumber(idx, line)));
            sum = calculate(sum, getNumber(idx, line), line.charAt(idx - 1));
            System.out.println("sum = " + sum);
        }


        recursive(idx+2, sum, line);
    }

    public int getNumber(int idx, String line) {
        return Character.getNumericValue(line.charAt(idx));
    }

    public int calculate(int a, int b, char sign) {
        switch (sign) {
            case '*':
                return a * b;

            case '+':
                return a + b;

            case '-':
                return a - b;
        }
        return 0;
    }
}
