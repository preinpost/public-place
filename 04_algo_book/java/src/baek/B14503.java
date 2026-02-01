package baek;

import java.util.Scanner;

public class B14503 {

    static class InitState {
        int sI;
        int sJ;
        int sD;

        public InitState(int sI, int sJ, int sD) {
            this.sI = sI;
            this.sJ = sJ;
            this.sD = sD;
        }
    }

    static int[][] check;

    static int[] dy = new int[] {0, -1, 0, 1};
    static int[] dx = new int[] {-1, 0, 1, 0}; // 0 : 위->왼쪽, 1 : 오른쪽->위, 2: 아래->오른쪽, 3: 왼쪽->아래

    static int answer = 1;

    public static void main(String[] args) {

        B14503 b14503 = new B14503();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // i (세로)
        int m = in.nextInt(); // j (가로)

        int[][] map = new int[n][m];
        check = new int[n][m];

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }

        b14503.solution(map, n, m, new InitState(a, b, c));

    }

    public void solution(int[][] map, int n, int m, InitState initState) {

        check[initState.sI][initState.sJ] = 1;
        execute(map, n, m, initState.sI, initState.sJ, initState.sD);

    }

    public void execute(int[][] map, int n, int m, int y, int x, int direction) {

        do {

            for (int i = 0; i < 4; i++) {

                if (direction == -1) direction = 3;

                int next_dy = y + dy[direction];
                int next_dx = x + dx[direction];

                if (next_dy < 0 || next_dy >= n || next_dx < 0 || next_dx >= m) continue;

                if (map[next_dy][next_dx] == 0 && check[next_dy][next_dx] == 0) {
                    y = next_dy;
                    x = next_dx;
                    check[y][x] = 1;
                    answer++;
                    i = -1;
                }
                direction--;
            }

            // 해당 방향에서 뒤로 보기 위한 조건
            int back = (direction + 3) % 4;
            int back_y = y + dy[back];
            int back_x = x + dx[back];

            if (map[back_y][back_x] == 1) {
                break;
            }

            y = back_y;
            x = back_x;
            check[y][x] = 1;


        } while (true);

        System.out.println(answer);

    }
}
