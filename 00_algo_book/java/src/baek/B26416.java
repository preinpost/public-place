package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 26416 New Password
public class B26416 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        StringBuffer answer = new StringBuffer();

        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(bf.readLine());
            String s = bf.readLine();
            StringBuffer sb = new StringBuffer();
            sb.append(s);

            if (!ruleTwo(s)) {
                sb.append("A");
            }

            if (!ruleThree(s)) {
                sb.append("a");
            }

            if (!ruleFour(s)) {
                sb.append(1);
            }

            if (!ruleFive(s)) {
                sb.append("#");
            }

            sb.append("a".repeat(ruleOne(sb.toString())));

            answer.append(String.format("Case #%d: ", i + 1)).append(sb);
            answer.append("\n");
        }

        System.out.println(answer);
    }


    static private int ruleOne(String s) {
        if (s.length() >= 7) {
            return 0;
        }
        return 7- s.length();
    }

    static private boolean ruleTwo(String s) {
        // 65 ~ 90
        for (char c : s.toCharArray()) {
            if (65 <= (int) c && (int) c <= 90) {
                return true;
            }
        }
        return false;
    }

    static private boolean ruleThree(String s) {
        // 97 ~ 122
        for (char c : s.toCharArray()) {
            if (97 <= (int) c && (int) c <= 122) {
                return true;
            }
        }
        return false;
    }

    static private boolean ruleFour(String s) {
        // 48 ~ 57
        for (char c : s.toCharArray()) {
            if (48 <= (int) c && (int) c <= 57) {
                return true;
            }
        }
        return false;
    }

    static private boolean ruleFive(String s) {
        // 35, 64, 42, 38
        for (char c : s.toCharArray()) {
            if ((int) c == 35 || (int) c == 64 || (int) c == 42 || (int) c == 38) {
                return true;
            }
        }
        return false;
    }


}