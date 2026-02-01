package programmers.book.P24;

// P24. 두 개 뽑아서 더하기

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> numSet = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                numSet.add(numbers[i] + numbers[j]);
            }
        }

        int[] numArr = numSet.stream()
                .mapToInt(i -> i)
                .toArray();

        Arrays.sort(numArr);

        return numArr;
    }
}