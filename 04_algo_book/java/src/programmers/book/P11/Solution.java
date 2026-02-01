package programmers.book.P11;

// P11. 문자열 내 p와 y의 개수
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int pCnt = 0;
        int yCnt = 0;

        for (char c : s.toCharArray()) {
            if (c == 'p' || c == 'P') {
                pCnt += 1;
            } else if (c == 'y' || c == 'Y') {
                yCnt += 1;
            }
        }

        if (pCnt != yCnt) return false;
        else return true;

    }
}