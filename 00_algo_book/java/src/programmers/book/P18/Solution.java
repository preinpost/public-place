package programmers.book.P18;

import java.util.*;

// P18. 모의고사
class Solution {

    private static int[] one = new int[] {1, 2, 3, 4, 5};
    private static int[] two = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
    private static int[] three = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int one_counter = 0;
        int two_counter = 0;
        int three_counter = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) one_counter += 1;
            if (answers[i] == two[i % two.length]) two_counter += 1;
            if (answers[i] == three[i % three.length]) three_counter += 1;
        }

        int max = Integer.MIN_VALUE;
        max = Math.max(max, one_counter);
        max = Math.max(max, two_counter);
        max = Math.max(max, three_counter);

        List<Integer> answer = new ArrayList<>();

        if (one_counter >= max) {
            answer.add(1);
        }
        if (two_counter >= max) {
            answer.add(2);
        }
        if (three_counter >= max) {
            answer.add(3);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}