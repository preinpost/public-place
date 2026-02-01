package programmers.book.P07;

// P07. 이상한 문자 만들기
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(caseChange(word.toString()));
                answer.append(' ');
                word.setLength(0);
            } else {
                word.append(c);
            }
        }

        if (word.length() > 0) {
            answer.append(caseChange(word.toString()));
        }

        return answer.toString();
    }

    private String caseChange(String s) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for (char c : s.toCharArray()) {
            if (idx % 2  == 0) sb.append(Character.toUpperCase(c));
            else sb.append(Character.toLowerCase(c));
            idx += 1;
        }

        return sb.toString();
    }
}