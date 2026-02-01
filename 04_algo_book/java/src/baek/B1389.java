package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 케빈 베이컨의 6단계 법칙
 */
public class B1389 {

    int n, m;
    List<List<Integer>> list = new ArrayList<>();
    int minCnt = Integer.MAX_VALUE, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        B1389 T = new B1389();

        T.input();
        T.search();
        System.out.println(T.answer);
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken()); // 유저 수
        m = Integer.parseInt(st.nextToken()); // 친구 관계 수

        list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }
    }

    public int bacon(int userNumber, int target) {
        int[] check = new int[n + 1];

        Queue<Integer> Q = new LinkedList<>();

        Q.offer(userNumber);
        check[userNumber] = 1;
        int cnt = 0;

        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                Integer poll = Q.poll();

                List<Integer> friends = list.get(poll);
                for (Integer friend : friends) {
                    if (check[friend] == 1) continue;

                    if (friend == target) {
                        return ++cnt;
                    }

                    Q.offer(friend);
                    check[friend] = 1;
                }
            }

            cnt++;
        }

        return cnt;
    }

    public void search() {
        for (int i = 1; i <= n; i++) {
            int sum = 0;

            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                sum += bacon(i, j);
            }
            if (minCnt > sum) {
                minCnt = sum;
                answer = i;
            }
        }
    }
}
