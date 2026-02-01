package lecture.L01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L0112 {

    public String solution(int len, String str) {
        // 7개가 하나의 단어

        // 1. # = 1, * = 0 으로 먼저 변환
        // 2. 7개씩 잘라서 10진수로 변환
        // 3. 변환된 값을 문자로 변환
        // 4. 문자값들 합치기
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        List<String> numList = new ArrayList<>(len);
        for (char s : str.toCharArray()) {
            counter++;
            if (s == '#') {
                sb.append("1");
            } else {
                sb.append("0");
            }

            if (counter % 7 == 0) {
                counter = 0;
                numList.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        sb = new StringBuilder();

        for (String s : numList) {
            int i = Integer.parseInt(s, 2);
            char c = (char) i;
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        L0112 T = new L0112();

        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();

        String str = in.nextLine();
        System.out.println(T.solution(len, str));
    }
}
