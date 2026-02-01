package programmers.book.P31;

// P31. 입국심사
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        long from = 0;
        long to = Long.MAX_VALUE;

        while (from < to) {
            long mid = (to - from) / 2 + from;

            long sum = 0;
            int status = -1;
            for (int t : times) {
                sum += mid / t;

                if (sum >= n) {
                    status = 1;
                    break;
                }
            }

            if (status == 1) {
                to = mid;
            } else {
                from = mid + 1;
            }
        }

        return to;
    }
}
