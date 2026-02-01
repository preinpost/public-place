package javis2022;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class B {

    /**
     * 반수 이상 득표한 후보가 나오면 그 사람을 당선자로 결정하고 투표 중단
     * 반수 이상 득표한 후보가 없으면 가장 적게 득표한 후보를 탈락시키고 재투표 실시 => Round
     *  head비교 후 => 탈락후보 결정 되면 탈락된 숫자 pop => 다시 Round
     */

    public static void main(String[] args) {
        B T = new B();

//        int[][] orders = {};
//
//
//        T.solution();
    }

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return this.second - o.second;
        }
    }

    public int[] solution(int[][] orders) {
        int[] answer = {};
        int half = 0;

        if (orders.length % 2 == 0) {
            half = orders.length / 2;
        } else {
            half = (orders.length + 1) / 2;
        }

        List<Queue<Integer>> queueList = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            queueList.add(new LinkedList<>());

            for (int j = 0; j < orders.length; j++) {
                queueList.get(i).add(orders[i][j]);
            }
        }

        int round = 0;
        Set<Integer> notCandid = new HashSet<>();

        while (round < orders.length) {
            Pair[] person = new Pair[orders.length];
//            int[] person = new int[orders.length];

            // 탈락후보 결정 전
            for (Queue<Integer> queue : queueList) {
                if (queue.isEmpty()) continue;

                person[queue.peek()].first = queue.peek();

                if (notCandid.contains(queue.peek())) {
                    queue.poll();
                    continue;
                }

                person[queue.peek()].second++;

                // 종료조건
                if (person[queue.peek()].second >= half) {
                    answer[0] = round;
                    answer[1] = queue.peek();
                    round = orders.length;
                    break;
                }

            }

            // 탈락후보 결정 후
            Arrays.sort(person);
            for (int i = 0; i < orders.length; i++) {
                if (notCandid.contains(person[i])) continue;
//                else notCandid.add();


            }


        }



        return answer;
    }


}
