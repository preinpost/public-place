package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이칙연산
public class B15726 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        String[] split = s.split(" ");

        double a = Double.parseDouble(split[0]);
        double b = Double.parseDouble(split[1]);
        double c = Double.parseDouble(split[2]);

        Double candid1 = a * b / c;
        Double candid2 = a / b * c;

        System.out.println(Math.max(candid1.intValue(), candid2.intValue()));
    }
}
