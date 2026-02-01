package programmers.book.P17;

import java.util.ArrayList;
import java.util.List;

// P17. 모음 사전
class Solution {

    private static final char[] ch = "AEIOU".toCharArray();

    public int solution(String word) {

        List<String> candid = new ArrayList<>();
        generateList("", candid);

        return candid.indexOf(word);
    }

    public void generateList(String word, List<String> candid) {
        candid.add(word);

        if (word.length() == 5) {
            return;
        }

        for (char c : ch) {
            generateList(word + c, candid);
        }
    }
}