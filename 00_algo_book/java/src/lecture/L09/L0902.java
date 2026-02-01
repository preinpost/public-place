package lecture.L09;

import java.util.*;
import java.util.stream.Collectors;

public class L0902 {

    static class Schedule {
        int start;
        int end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public void solution(int n, List<Schedule> list) {

        list.sort(new Comparator<Schedule>() {
            @Override
            public int compare(Schedule o1, Schedule o2) {
                if (o1.end == o2.end)
                    return o1.start - o2.start;

                return o1.end - o2.end;
            }
        });

        int current = 0;
        int answer = 0;
        for (Schedule schedule : list) {
            if (schedule.start >= current) {
                current = schedule.end;
                answer++;
            }
        }

        System.out.println(answer);

    }

    public static void main(String[] args) {

        L0902 T = new L0902();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        List<Schedule> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Schedule(in.nextInt(), in.nextInt()));
        }

        T.solution(n, list);
    }
}
