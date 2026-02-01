package leetcode.N733;

import java.util.LinkedList;
import java.util.Queue;

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

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        Queue<Pair> Q = new LinkedList<>();
        Q.offer(new Pair(sr, sc));
        int[][] check = new int[image.length][image[0].length];
        check[sr][sc] = 1;

        while(!Q.isEmpty()) {
            Pair poll = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nI = di[i] + poll.first;
                int nJ = dj[i] + poll.second;

                if (!isValidBoundary(nI, nJ, image)) continue;
                if (check[nI][nJ] == 1) continue;

                check[nI][nJ] = 1;

                if (image[nI][nJ] != image[sr][sc]) continue;

                image[nI][nJ] = color;
                Q.offer(new Pair(nI, nJ));
                check[nI][nJ] = 1;
            }
        }

        image[sr][sc] = color;

        return image;
    }

    boolean isValidBoundary(int i, int j, int[][] image) {
        return i >= 0 && j >= 0 && i < image.length && j < image[0].length;
    }
}