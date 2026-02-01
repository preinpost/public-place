package programmers;

import java.util.ArrayList;
import java.util.List;

public class 문자열압축 {

    public int solution(String s) {
        if (s.length() == 1)
            return 1;

        List<List<String>> list = new ArrayList<>();
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= s.length()/2+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= s.length() / 2; i++) {

            for (int j = 0; j <= s.length(); j+=i) {
                if (j + i > s.length()) {
                    String substring = s.substring(j, s.length());
                    if (!substring.equals(""))
                        list.get(i).add(substring);
                    break;
                }

                String s1 = s.substring(j, j + i);
                list.get(i).add(s1);
            }
        }

        for (List<String> strings : list) {

            int p1 = 0;
            int p2 = 0;
            int cnt = 1;
            String tot = "";

            while (p1 < strings.size()) {
                p2++;

                if (p2 == strings.size()) {
                    tot = getString(tot, cnt, strings.get(p2-1));
                    break;
                }

                String sp1 = strings.get(p1);
                String sp2 = strings.get(p2);

                if (sp1.equals(sp2)) {
                    cnt++;
                } else {
                    tot = getString(tot, cnt, sp1);
                    cnt = 1;
                    p1 = p2;
                }
            }

            if (!tot.equals("")) {
                answer = Math.min(answer, tot.length());
            }

        }

        return answer;
    }

    private String getString(String tot, int cnt, String sp1) {
        if (cnt == 1) tot += sp1;
        else  tot += cnt + sp1;
        return tot;
    }

    public static void main(String[] args) {

        문자열압축 T = new 문자열압축();

//        String s = "a";
        String s = "z";
//        String s = "aabbaccc"; // 2a2ba3c
//        String s = "ababcdcdababcdcd"; // 2ababcdcd
//        String s = "abcabcdede"; // 2abcdede
//        String s = "abcabcabcabcdededededede";
//        String s = "xababcdcdababcdcd";

        System.out.println(T.solution(s));
    }
}
