package leetcode.N1584;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    /*
        맨하탄 거리로 계산
     */

    int[] disjoint;
    int answer = 0;

    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        int[][] dis = new int[length][length];

        disjoint = new int[length];
        for (int i = 0; i < length; i++) {
            disjoint[i] = i;
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> dis[a[0]][a[1]] - dis[b[0]][b[1]]);

        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                dis[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.offer(new int[]{i, j});
            }
        }

        while (!pq.isEmpty() && length > 1) {
            int[] poll = pq.poll();

            if (union(poll[0], poll[1])) {
                answer += dis[poll[0]][poll[1]];
                length--;
            }
        }

        return answer;
    }

    public int find(int idx) {
        if (disjoint[idx] == idx) {
            return idx;
        }

        return disjoint[idx] = find(disjoint[idx]);
    }

    public boolean union(int x, int y) {

        int result_x = find(x);
        int result_y = find(y);

        if (result_x == result_y) return false;

        if (result_x < result_y) {
            disjoint[result_x] = result_y;
        } else if (result_x > result_y){
            disjoint[result_y] = result_x;
        } else {
            disjoint[result_y] = result_x;
            disjoint[result_x] = disjoint[result_x] + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

//        int[][] arr = new int[][] {{0,0},{2,2},{3,10},{5,2},{7,0}};
        int[][] arr = new int[][] {{-14,-14},{-18,5},{18,-10}, {18, 18}, {10, -2}};
        System.out.println(sol.minCostConnectPoints(arr));

    }

}
