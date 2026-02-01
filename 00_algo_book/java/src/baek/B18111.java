package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18111 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken());// 가로
        int b = Integer.parseInt(st.nextToken());// 인벤토리

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer_floor = Integer.MIN_VALUE;
        int answer_time = Integer.MAX_VALUE;

        for (int i = 0; i < 257; i++) {
            int time = 0;
            int init_b = b;

            for (int j = 0; j < n; j++) {

                for (int k = 0; k < m; k++) {
                    if (map[j][k] - i > 0) {
                        // 블럭을 제거하는 경우
                        time += (map[j][k] - i) * 2;
                        init_b += map[j][k] - i;
                    } else if (map[j][k] - i < 0) {
                        // 인벤에서 꺼내는 경우
                        time += (map[j][k] - i) * -1;
                        init_b -= (map[j][k] - i) * -1;
                    }

                }
            }

            if (init_b < 0) continue;

            if (answer_time >= time) {
                answer_time = time;
                answer_floor = Math.max(answer_floor, i);
            }
        }

        System.out.printf("%d %d", answer_time, answer_floor);
    }
}
