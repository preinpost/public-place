package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 카드2
 */
public class B2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            Q.offer(i);
        }

        while (Q.size() > 1) {
            Q.poll();
            Integer poll = Q.poll();
            Q.offer(poll);
        }

        System.out.println(Q.poll());
    }
}
