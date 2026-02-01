package programmers.book.P06;

// P06. 시저 암호
class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        // 대문자 : 65 ~ 90
        // 소문자 : 97 ~ 122

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                // 소문자
                if (c + n > 122) {
                    sb.append((char) (c + n - 26));
                } else {
                    sb.append((char) (c + n));
                }
            } else if (c >= 'A' && c <= 'Z') {
                // 대문자
                if (c + n > 90) {
                    sb.append((char) (c + n - 26));
                } else {
                    sb.append((char) (c + n));
                }
            } else {
                // 공백
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
