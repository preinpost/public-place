package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1546 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        String s = bf.readLine();

        int[] ints = Collections.list(new StringTokenizer(s)).stream()
                .map(token -> (String) token)
                .mapToInt(Integer::parseInt).toArray();

        double sum = 0;
        double max = Float.MIN_VALUE;

        for (int anInt : ints) {
            max = Math.max(max, anInt);
            sum += anInt;
        }

        double result = (sum / n) / max * 100;

        System.out.println(result);
    }
}
