package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 검증수
public class B2475 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int answer = 0;

        while (st.hasMoreTokens()) {
            Integer num = Integer.parseInt(st.nextToken());
            answer += num * num;
        }
        System.out.println(answer % 10);
    }

}
