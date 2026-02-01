package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 뱀과 사다리 게임
 */
public class B16928 {

    int[] move;
    int[] visited;

    public static void main(String[] args) throws IOException {

        B16928 T = new B16928();

        T.input();
        System.out.println(T.roll(1));
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int tot = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        move = new int[101];
        visited = new int[101];

        for (int i = 0; i < tot; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);

            move[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
    }

    public int roll(int current) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(current);
        int answer = 1;

        while (true) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                Integer poll = Q.poll();

                for (int j = 1; j <= 6; j++) {
                    int next = poll + j;
                    if (next >= 100) return answer;

                    int candid = eval(next);
                    if (candid == 100) return answer;

                    if (visited[candid] == 1) continue;
                    visited[candid] = 1;
                    Q.offer(candid);

                }
            }
            answer++;
        }
    }

    public int eval(int number) {
        if (move[number] == 0) return number;
        return eval(move[number]);
    }
}
