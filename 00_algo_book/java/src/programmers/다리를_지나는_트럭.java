package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {

    /*
        다리를 건너려면 최소 몇 초가 걸리는지 구해야함

        다리에 올라갈 수 있는 트럭 수: bridge_length => 큐의 길이
        다리가 견딜 수 있는 무게: weight
        트럭 별 무게: truck_weights
     */

    public static void main(String[] args) {

        다리를_지나는_트럭 T = new 다리를_지나는_트럭();

//        int ans = T.solution(1, 1, new int[]{1});
//        int ans = T.solution(2, 2, new int[]{1, 1});
//        int ans = T.solution(2, 10, new int[]{7, 4, 5, 6});
        int ans = T.solution(100, 100, new int[]{10});
//        int ans = T.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10});
        System.out.println("ans = " + ans);
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> Q = new LinkedList<>();
        int cursor = 0;
        int currentWeight = 0;

        while (cursor < truck_weights.length) {

            int nextTruck = truck_weights[cursor];

            if (Q.isEmpty()) {
                Q.offer(nextTruck);
                currentWeight += nextTruck;
                cursor++;
                answer++;
            }

            else if (!isCanAddQueueBySize(bridge_length, Q)) {
                Integer poll = Q.poll();
                currentWeight -= poll;
            }

            else {

                if (!isCanAddQueueByWeight(weight, currentWeight, nextTruck)) {
                    Q.offer(0);
                } else {
                    Q.offer(nextTruck);
                    currentWeight += nextTruck;
                    cursor++;
                }

                answer++;
            }
        }

        return answer + bridge_length;
    }

    public boolean isCanAddQueueByWeight(int weight, int currentWeight, int nextTruck) {
        return currentWeight + nextTruck <= weight;
    }

    public boolean isCanAddQueueBySize(int bridge_length, Queue<Integer> Q) {
        return bridge_length > Q.size();
    }
}
