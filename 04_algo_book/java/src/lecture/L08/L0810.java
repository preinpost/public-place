package lecture.L08;

import java.util.Scanner;

public class L0810 {

    static int[] di = {1, 0, -1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int answer = 0;

    public void solution(int[][] map) {

        DFS(0, 0, map);
        System.out.println(answer);

    }

    public void DFS(int i, int j, int[][] map) {
        if (i == -1 || j == -1 || i == 7 || j == 7) return;

        if (map[i][j] == 1) return;

        if (i == 6 && j == 6) {
            answer++;
            return;
        }

        map[i][j] = 1;

        for (int k = 0; k < 4; k++) {
            DFS(i + di[k], j + dj[k], map);
        }

        map[i][j] = 0;
    }

    public static void main(String[] args) {

        L0810 T = new L0810();

        Scanner in = new Scanner(System.in);

        int[][] map = new int[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j] = in.nextInt();
            }
        }

        T.solution(map);
    }
}
