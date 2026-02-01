package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// A + B - C
public class B31403 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String A = bf.readLine();
        String B = bf.readLine();
        int C = Integer.parseInt(bf.readLine());

        StringBuffer answer = new StringBuffer();
        answer.append(Integer.parseInt(A) + Integer.parseInt(B) - C);
        answer.append("\n");
        answer.append(Integer.parseInt(A + B) - C);

        System.out.println(answer);
    }
}
