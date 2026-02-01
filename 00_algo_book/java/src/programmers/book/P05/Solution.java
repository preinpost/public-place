package programmers.book.P05;

// P05. 자연수 뒤집어 배열로 만들기
class Solution {
    public int[] solution(long n) {
        String stringInteger = String.valueOf(n);
        StringBuilder sb = new StringBuilder(stringInteger);
        sb.reverse();
        char[] charArray = sb.toString().toCharArray();
        int[] answer = new int[sb.length()];

        for (int i = 0; i < sb.length(); i++) {
            answer[i] = charArray[i] - '0';
        }

        return answer;
    }
}
