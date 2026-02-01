package baek;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2023은 무엇이 특별할까?
public class B31090 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            int year = Integer.parseInt(bf.readLine());
            int nextYear = year + 1;

            int div = year % 100;

            if (nextYear % div == 0) {
                System.out.println("Good");
            } else {
                System.out.println("Bye");
            }
        }
    }
}
