package programmers.book.P10;


// P10. 이진 변환 반복하기
class Solution {

    private int removedCount = 0;

    public int[] solution(String s) {
        int[] answer = new int[2];
        int round = 0;

        while (!"1".equals(s)) {
            String firstActionResult = removeZero(s);
            String secondActionResult = lengthToBinary(firstActionResult);

            s = secondActionResult;

            round += 1;
        }

        answer = new int[] {round, removedCount};

        return answer;
    }

    private String removeZero(String s) {
        int counter = 0;
        StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '0') {
                removedCount += 1;
                continue;
            }

            builder.append(c);
        }

        return builder.toString();
    }

    private String lengthToBinary(String s) {
        int length = s.length();

        return Integer.toString(length, 2);
    }
}
