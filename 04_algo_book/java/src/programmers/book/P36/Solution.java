package programmers.book.P36;

// P36. 없는 숫자 더하기
class Solution {
    public int solution(int[] numbers) {
        int[] num_arr = new int[10];

        for (int i : numbers) {
            if (num_arr[i] == 1) continue;

            num_arr[i] = 1;
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            if (num_arr[i] == 0) answer += i;
        }

        return answer;
    }
}