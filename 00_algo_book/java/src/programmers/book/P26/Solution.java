package programmers.book.P26;

// P26. 문자열 내림차순으로 배치하기
class Solution {
    public String solution(String s) {
        char[] cArr = s.toCharArray();
        return s.chars()
                .boxed()
                .sorted((c1, c2) -> c2 - c1)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}