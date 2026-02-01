package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 이중 우선순위 큐
 */
public class B7662 {

    static class Pair implements Comparable<Pair>{
        Integer first;
        Integer second;

        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return this.first >= o.first ? 1 : -1; // 여기서 그냥 this.first - o.first 하면 overflow 날 수 있음.
        }
    }

    public static void main(String[] args) throws IOException {
        B7662 T = new B7662();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        StringBuffer answer = new StringBuffer();

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(bf.readLine());

            Queue<Pair> HQ = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Pair> LQ = new PriorityQueue<>();

            for (int j = 0; j < k; j++) {
                String line = bf.readLine();
                String[] split = line.split(" ");

                String cmd = split[0];
                Integer number = Integer.parseInt(split[1]);

                if (cmd.equals("I")) {
                    Pair pair = new Pair(number, 0);
                    LQ.offer(pair);
                    HQ.offer(pair);
                } else {

                    switch (number) {
                        case 1:
                            do {
                                if (HQ.isEmpty()) break;
                                Pair poll = HQ.poll();
                                if (poll.second == 1) continue;

                                poll.second = 1;
                                break;

                            } while (true);

                            break;
                        case -1:
                            do {
                                if (LQ.isEmpty()) break;
                                Pair poll = LQ.poll();
                                if (poll.second == 1) continue;

                                poll.second = 1;
                                break;

                            } while (true);

                            break;
                    }
                }
            }

            List<Integer> answerList = new ArrayList<>();

            do {
                if (LQ.isEmpty()) break;
                Pair poll = LQ.poll();
                if (poll.second == 1) continue;

                answerList.add(poll.first);
                break;

            } while (true);

            do {
                if (HQ.isEmpty()) break;
                Pair poll = HQ.poll();
                if (poll.second == 1) continue;

                answerList.add(poll.first);
                break;

            } while (true);

            if (answerList.isEmpty()) answer.append("EMPTY\n");
            else {
                answer.append(answerList.get(answerList.size() - 1)).append(" ");
                answer.append(answerList.get(0)).append("\n");
            }
        }
        System.out.println(answer);
    }
}
