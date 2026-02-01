package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 명장 남정훈
public class B15734 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        String[] split = s.split(" ");
        int L = Integer.parseInt(split[0]);
        int R = Integer.parseInt(split[1]);
        int A = Integer.parseInt(split[2]);

        int answer = 0;

        int diff = Math.abs(L - R);

        if (diff > A) {
            answer = (Math.min(L, R) + A) * 2;
        } else {
            int div = A - diff;
            answer = (div / 2 + diff + Math.min(L, R)) * 2;
        }
        System.out.println(answer);
    }
}
