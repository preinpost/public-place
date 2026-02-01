package lecture.L04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class L0404 {

    public void solution(String s, String t) {
        int p1 = 0;
        int p2 = t.length()-1;
        int answer = 0;

        Map<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        char[] sChars = s.toCharArray();
        for (int i = 0; i < p2; i++) {
            sMap.put(sChars[i], sMap.getOrDefault(sChars[i], 0)+1);
        }

        while (p2 < s.length()) {
            sMap.put(sChars[p2], sMap.getOrDefault(sChars[p2], 0)+1);
            p2++;

            if (tMap.equals(sMap)) answer++;


            sMap.put(sChars[p1], sMap.get(sChars[p1])-1);
            if (sMap.get(sChars[p1]) == 0) sMap.remove(sChars[p1]);
            p1++;
        }

        System.out.println(answer);

    }

    public static void main(String[] args) {

        L0404 T = new L0404();

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();

        T.solution(s, t);
    }
}
