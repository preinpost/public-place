package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 숨바꼭질
 */
public class B1697 {

    int n;
    int m;
    int[] check = new int[100001];

    public static void main(String[] args) throws IOException {
        B1697 T = new B1697();

        T.input();
        int answer = T.find();
        System.out.println(answer);

    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        n = Integer.parseInt(st.nextToken()); // 수빈
        m = Integer.parseInt(st.nextToken()); // 동생
    }

    public int find() {
        if (n == m) {
            return 0;
        }

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(n);

        int cnt = 1;
        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                Integer poll = Q.poll();

                for (int j = 0; j < 3; j++) {
                    int nI = 0;
                    switch (j) {
                        case 0:
                           nI = poll - 1;
                           break;
                        case 1:
                            nI = poll + 1;
                            break;
                        case 2:
                            nI = poll * 2;
                            break;
                    }

                    if (nI == m) {
                        return cnt;
                    }

                    if (nI > 100_000) continue;
                    if (nI < 0) continue;
                    if (check[nI] == 1) continue;

                    check[nI] = 1;
                    Q.offer(nI);
                }
            }

            cnt += 1;
        }

        return -1;
    }
}
