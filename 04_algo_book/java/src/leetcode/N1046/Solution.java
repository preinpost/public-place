package leetcode.N1046;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// 1046. Last Stone Weight
class Solution {
    public int lastStoneWeight(int[] stones) {

        if (stones.length == 1) return 1;

        Queue<Integer> Q = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for (int i : stones) {
            Q.offer(i);
        }

        while (Q.size() > 1) {
            int first = Q.poll();
            int second = Q.poll();

            if (first - second != 0) {
                Q.offer(Math.abs(first - second));
            }
        }

        if (Q.size() == 1) {
            return Q.poll();
        }

        return 0;
    }
}