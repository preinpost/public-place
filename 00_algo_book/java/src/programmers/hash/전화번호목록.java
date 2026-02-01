package programmers.hash;

import java.util.*;

public class 전화번호목록 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();

        for (String s : phone_book) {
            map.put(s, 0);
        }


        for (int i = 0; i < phone_book.length; i++) {
            String currentNum = phone_book[i];

            for (int j = 1; j < currentNum.length(); j++) {
                boolean b = map.containsKey(currentNum.substring(0, j));
                if (b) {
                    answer = false;
                    return answer;
                }

            }

        }


        return answer;
    }

    public static void main(String[] args) {

        전화번호목록 T = new 전화번호목록();

        String[] phone_book;

        phone_book = new String[]{"12","123","1235","567","88"};

        boolean solution = T.solution(phone_book);
        System.out.println(solution);
    }
}
