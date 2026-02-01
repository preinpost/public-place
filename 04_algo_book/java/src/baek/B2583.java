package baek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B2583 {

    static int[] dx = new int[]{1, 0, -1 , 0};
    static int[] dy = new int[]{0, 1, 0 , -1};

    static int cnt;

    public static void main(String[] args) {
        B2583 b2583 = new B2583();

        Scanner in = new Scanner(System.in);

        List<Integer> arr = new ArrayList<>();

        int m = in.nextInt(); // y
        int n = in.nextInt(); // x
        int k = in.nextInt();

        int[][] map = new int[m][n];

        for (int i = 0; i < k; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();

            int x2 = in.nextInt();
            int y2 = in.nextInt();

            for (int j = y1; j < y2; j++) {
                for (int l = x1; l < x2; l++) {
                    map[m-1-j][l] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt = 0;
                b2583.dfs(j, i, n, m, map);
                if (cnt != 0) arr.add(cnt);
            }
        }
        Collections.sort(arr);

        System.out.println(arr.size());

        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }

    public void dfs(int x, int y, int n, int m, int[][] map) {
        if (map[y][x] == 1) return;

        cnt++;
        map[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if (next_x < 0 || next_y < 0 || next_x >= n || next_y >= m) continue;

            dfs(next_x, next_y, n, m, map);
        }
    }
}
