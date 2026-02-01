package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14935 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String current;
        current = bf.readLine();

        while (true) {
            int numLength = current.length();
            int firstNum = current.charAt(0) - 48;

            String next = String.valueOf(firstNum * numLength);

            if (current.equals(next)) {
                System.out.println("FA");
                return;
            } else {
                current = next;
            }
        }
    }
}
