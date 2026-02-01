package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A02 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();

        String[] split = s.split(" ");
        String n = split[0];
        String x = split[1];

        s = bf.readLine();
        split = s.split(" ");

        for (String a : split) {
            if (x.equals(a)) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }
}
