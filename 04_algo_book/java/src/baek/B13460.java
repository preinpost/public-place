package baek;

import java.util.Scanner;

public class B13460 {

    static class Ball{
        String type;
        int i, j;
        int count = 0;
        boolean status = false;

        public Ball(String type, int i, int j) {
            this.type = type;
            this.i = i;
            this.j = j;
        }
    }

    static int[] dx = new int[]{1, 0, -1, 0}; // 가로 (j)
    static int[] dy = new int[]{0, 1, 0, -1}; // 세로 (i)
    static int[][][][] visited;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        B13460 b13460 = new B13460();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // 세로 (i)
        int m = in.nextInt(); // 가로 (j)

        Ball red = null;
        Ball blue = null;

        in.nextLine();

        char[][] map = new char[n][m];
        visited = new int[n][m][n][m];

        for (int i = 0; i < n; i++) {

            String s = in.nextLine();
            for (int j = 0; j < s.length(); j++) {
                char curr = s.charAt(j);
                if (curr == 'B') {
                    blue = new Ball("blue", i, j);
                } else if (curr == 'R') {
                    red = new Ball("red", i, j);
                }

                map[i][j] = curr;
            }
        }

        b13460.solution(n, m, red, blue, map);
    }

    public void solution(int n, int m, Ball red, Ball blue, char[][] map) {


    }

    public void bfs() {

    }


}
