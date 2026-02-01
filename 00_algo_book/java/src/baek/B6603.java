package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로또
public class B6603 {

    int[] numbers;
    StringBuffer answer = new StringBuffer();

    public static void main(String[] args) throws IOException {
        B6603 T = new B6603();

        T.solution();
        System.out.println(T.answer);
    }

    void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = bf.readLine();
            StringTokenizer st = new StringTokenizer(s);

            String k = st.nextToken();

            if (k.equals("0")) break;

            numbers = new int[Integer.parseInt(k)];

            int idx = 0;
            while (st.hasMoreTokens()) {
                numbers[idx++] = Integer.parseInt(st.nextToken());
            }

            combination(0, 0, 6, new int[6], numbers);
            answer.append("\n");
        }
    }

    void combination(int depth, int s, int r, int[] candid, int[] numbers) {
        if (depth == r) {
            for (int i : candid) {
                answer.append(i).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = s; i < numbers.length; i++) {
            candid[depth] = numbers[i];
            combination(depth + 1, i + 1, r, candid, numbers);
        }
    }
}
