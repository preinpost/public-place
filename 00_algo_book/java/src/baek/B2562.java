package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2562 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] answer = new int[2]; // 0에 숫자, 1에 인덱스
        answer[0] = Integer.MIN_VALUE;

        for (int i = 1; i <= 9; i++) {
            int number = Integer.parseInt(bf.readLine());

            if (number > answer[0]) {
                answer[0] = number;
                answer[1] = i;
            }
        }

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
