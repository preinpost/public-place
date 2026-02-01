package programmers.book.P09;

// P09. 3진법 뒤집기
class Solution {
    public int solution(int n) {
        int answer = 0;

        String three = Integer.toString(n, 3);
        StringBuilder builder = new StringBuilder(three).reverse();

        answer = Integer.parseInt(builder.toString(), 3);

        return answer;
    }
}
