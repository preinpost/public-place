package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2908 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        StringBuffer sb = new StringBuffer(st.nextToken());
        int a = Integer.parseInt(sb.reverse().toString());

        sb = new StringBuffer(st.nextToken());
        int b = Integer.parseInt(sb.reverse().toString());

        System.out.println(Math.max(a, b));
    }
}
