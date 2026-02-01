package programmers.book.P02;

// P02. 삼각 달팽이
class Solution {

    private static int[] di = {1, 0, -1};
    private static int[] dj = {0, 1, -1};

    public int[] solution(int n) {
        int[] answer = {};
        int[][] arr = new int[n][n];
        int i = 0, j = 0, d = 0, v = 1;


        while (true) {
            arr[i][j] = v++;

            int nextI = i + di[d];
            int nextJ = j + dj[d];

            if (nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n || arr[nextI][nextJ] != 0) {
                d += 1;
                d = d % 3;

                nextI = i + di[d];
                nextJ = j + dj[d];

                if (nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n || arr[nextI][nextJ] != 0) break;
            }

            i = nextI;
            j = nextJ;
        }

        answer = new int[v - 1];

        int idx = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }

        return answer;
    }
}