package programmers.book.P28;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

// P28. 가장 큰 수
class Solution {
    public String solution(int[] numbers) {

        String answer = IntStream.of(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    Integer a = Integer.parseInt(s1 + s2);
                    Integer b = Integer.parseInt(s2 + s1);

                    return b - a;
                })
                .collect(Collectors.joining())
                .replaceAll("^0+$", "0");

        return answer;
    }
}