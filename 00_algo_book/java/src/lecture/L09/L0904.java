package lecture.L09;

import java.util.*;

public class L0904 {

    static class Lecture implements Comparable<Lecture> {
        int money;
        int time;

        public Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.time - this.time;
        }
    }

    public void solution(int n, List<Lecture> arr) {

        Collections.sort(arr);

        int answer = 0;
        int current_time = arr.get(0).time;

        PriorityQueue<Lecture> PQ = new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return o2.money - o1.money;
            }
        });

        int i = 0;
        while (current_time > 0) {

            if (arr.size() == i) {
                if (!PQ.isEmpty()) {
                    Lecture poll = PQ.poll();
                    answer += poll.money;
                    break;
                }
            }

            if (arr.get(i).time < current_time) {
                current_time--;

                if (!PQ.isEmpty()) {
                    Lecture poll = PQ.poll();
                    answer += poll.money;
                }
            } else {
                PQ.offer(arr.get(i));
                i++;
            }

        }

        System.out.println(answer);

    }

    public static void main(String[] args) {

        L0904 T = new L0904();

        Scanner in = new Scanner(System.in);
        List<Lecture> arr = new ArrayList<>();

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            arr.add(new Lecture(in.nextInt(), in.nextInt()));
        }

        T.solution(n, arr);
    }
}
