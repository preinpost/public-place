package programmers.book.P38;

import java.util.*;

// programmers P38. 피보나치 수
class Solution {

    int[] memo = new int[100000 + 1];

    public int solution(int n) {
        Arrays.fill(memo, -1);

        for (int i = 0; i <= n; i++) {
            fibo(n);
        }
        return fibo(n);
    }

    private int fibo(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }


        if (n == 0) return 0;
        if (n == 1) return 1;

        return memo[n] = (fibo(n-1) + fibo(n-2)) % 1234567;
    }
}
