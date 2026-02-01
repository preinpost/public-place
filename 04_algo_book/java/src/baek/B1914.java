package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B1914 {

    public static void main(String[] args) throws IOException {

        B1914 b1914 = new B1914();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        b1914.solution(n);
    }

    private void solution(int n) {
        System.out.println(BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE));
        if (n <= 20){
            recursive(n, 1, 3, 2);
        }
    }

    public void recursive(int num, int from, int to, int other) {

        if (num == 0) {
            return;
        }

        recursive(num-1, from, other, to);
        System.out.println(from + " " + to);
        recursive(num-1, other, to, from);
    }
}
