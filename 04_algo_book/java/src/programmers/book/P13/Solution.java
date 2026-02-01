package programmers.book.P13;

// P13. 문자열 다루기 기본
class Solution {
    public boolean solution(String s) {
        if (!(s.length() == 4 || s.length() == 6)) return false;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) == false) return false;
        }
        return true;
    }
}
