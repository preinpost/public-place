package baek;

import java.util.Scanner;

public class B1978 {

    static int answer;
    static int[] cache = new int[1001];

    public static void main(String[] args) {

        B1978 b1978 = new B1978();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        answer = n;

        for (int i = 0; i < n; i++) {
            b1978.solution(in.nextInt());
        }

        System.out.println(answer);
    }

    private void solution(int num) {
        if (num == 1) {
            answer--;
            return;
        }

        if (cache[num] == 1) return;
        else if (cache[num] == 2) answer--;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                answer--;
                cache[num] = 2;
                return;
            }
        }
        cache[num] = 1;
    }
}
