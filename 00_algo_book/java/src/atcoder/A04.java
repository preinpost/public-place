package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A04 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(bf.readLine());

        for (int i = 9; i >= 0; i--) {
            int x = 1 << i;
            sb.append(s / x % 2);
        }

        System.out.println(sb);
    }
}