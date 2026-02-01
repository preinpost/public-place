package sk2022;

import java.util.Arrays;

public class A {

    public int solution(int money, int[] costs) {
        int answer = 0;

        int[] kind = {1, 5, 10, 50, 100, 500};
        int[] dp = new int[money+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < costs.length; i++) {
            int currentCost = costs[i];
            int currentKind = kind[i];

            for (int j = currentKind; j <= money; j++) {
                dp[j] = Math.min(dp[j], dp[j-currentKind] + currentCost);
            }
        }

        answer = dp[money];

        return answer;
    }

    public static void main(String[] args) {
        A a = new A();

        int money = 4578;
        int[] costs = {1, 4, 99, 35, 50, 1000};

        a.solution(money, costs);
    }
}
