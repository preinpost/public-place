package dev2022.a;

public class Second {

    static int[] di = {1, 0, 1, 1};
    static int[] dj = {0, 1, 1, -1};
    static int answer = 0;

    public static void main(String[] args) {
        Second second = new Second();

        int h, w, n;
        String[] board = new String[]{"111100000","000010011","111100011","111110011","111100011","111100010","111100000"}; // 10
//        ["11111","11111","11111","11111","11111"] // 12

        h=7;
        w=9;
        n=4;

        second.solution(h, w, n, board);
    }

    public int solution(int h, int w, int n, String[] board) {
//        int answer = -1;

        int[][] map = new int[h][w];

        for (int i = 0; i < board.length; i++) {
            String cur = board[i];
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(cur.charAt(j)));
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j =0; j < w; j++) {
            dfs(i, j, 0, 0, h,w,n,map);
            }
        }

        System.out.println(answer);
        return answer;
    }

    public void dfs(int i, int j, int d, int cnt, int h, int w, int n, int[][] map) {

        if (j >= w || i >= h || j < 0 || i < 0) return;
        if (map[i][j] == 0) return;

//        if (cnt > n) {
//            answer--;
//            return;
//        }

        if (map[i][j] == 1) {
            cnt++;
        }

        if (cnt == n) {
            answer++;
        }

        for (int k = 0; k < di.length; k++) {
//            if (d != k) continue;

            int next_i = i + di[k];
            int next_j = j + dj[k];

            dfs(next_i, next_j, k, cnt, h,w,n,map);
        }



    }
}
