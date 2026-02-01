package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// FBI
public class B2857 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] agent = new int[5];

        for (int i = 0; i < 5; i++) {
            String s = readLine();
            if (s.contains("FBI")) {
                agent[i] = 1;
            }
        }

        StringBuffer sb = new StringBuffer();


        for (int i = 0; i < 5; i++) {
            if (agent[i] == 1) {
                sb.append(i + 1);
                sb.append(" ");
            }
        }

        if (sb.length() == 0) {
            System.out.println("HE GOT AWAY!");
        } else {
            System.out.println(sb);
        }
    }


    static private String readLine() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
