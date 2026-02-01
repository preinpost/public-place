package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5522 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        for (int i = 0; i < 5; i++) {
            String s = bf.readLine();
            int num = Integer.parseInt(s);

            total += num;
        }
        System.out.println(total);
    }
}
