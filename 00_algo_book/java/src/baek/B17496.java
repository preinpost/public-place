package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17496 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String[] split = s.split(" ");

        int n = Integer.parseInt(split[0]);
        int t = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);
        int p = Integer.parseInt(split[3]);

        int i = 1;
        int q = 0;
        while (i + t <= n) {
            i += t;
            q += c;
        }

        System.out.println(p * q);
    }
}