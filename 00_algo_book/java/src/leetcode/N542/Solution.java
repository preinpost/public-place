package leetcode.N542;

import java.util.LinkedList;
import java.util.Queue;

// 542. 01 Matrix
class Solution {

    static int[] di = {1, 0, -1, 0};
    static int[] dj = {0, 1, 0, -1};

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] visited = new int[mat.length][mat[0].length];

        Queue<Pair> Q = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    Q.offer(new Pair(i, j));
                    visited[i][j] = 1;
                }
            }
        }

        int distance = 1;
        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                Pair poll = Q.poll();

                for (int k = 0; k < 4; k++) {
                    int nI = poll.first + di[k];
                    int nJ = poll.second + dj[k];

                    if(!isValidBoundary(nI, nJ, mat)) continue;
                    if (visited[nI][nJ] == 1) continue;

                    mat[nI][nJ] = distance;
                    visited[nI][nJ] = 1;
                    Q.offer(new Pair(nI, nJ));
                }
            }
            distance += 1;
        }

        return mat;
    }


    boolean isValidBoundary(int i, int j, int[][] mat) {
        return i >= 0 && j >= 0 && i < mat.length && j < mat[0].length;
    }
}