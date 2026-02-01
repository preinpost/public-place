package toss2022;

import java.util.HashSet;
import java.util.Set;

public class Z {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        /**
         * 약수가 3개인 수 중 3번째를 구하라
         * 최대길이는 Integer.MAX
         *
         * 4, 192
         * 655
         */

        Z z = new Z();

        int n = 4;
        int k = 192;

        int result = z.solution(n, k);
        System.out.println("result = " + result);

        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("elapsedTime = " + elapsedTime);


    }

    public int solution(int n, int k) {

        int cnt = 0;

        for (int i = 1; i <Integer.MAX_VALUE; i++) {
            int result = formula(i);

            if (result == n) {
                cnt++;
            }
            if (cnt == k) return i;
        }

        return -1;
    }

    public int formula(int num) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> candid = new HashSet<>();

        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                candid.add(i);
                result.add(i);
            }
        }

        for (Integer integer : candid) {
            result.add(num / integer);
        }

        return result.size();
    }
}
