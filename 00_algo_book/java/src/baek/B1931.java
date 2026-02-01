package baek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B1931 {

    static class Pair implements Comparable<Pair> {
        int st;
        int en;

        public Pair(int st, int en) {
            this.st = st;
            this.en = en;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.en == o.en) return this.st - o.st;
            return this.en - o.en;
        }
    }

    public static void main(String[] args) {

        B1931 b1931 = new B1931();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            list.add(new Pair(a, b));
        }

        b1931.solution(list);
    }

    public void solution(List<Pair> list) {
        Collections.sort(list);

        int answer = 1;
        int pos = 1;
        int currEnd = list.get(0).en;

        do {
            for (int i = pos; i < list.size(); i++) {
                pos = i;

                if (list.get(i).st < currEnd) continue;

                else if (list.get(i).st == currEnd && list.get(i).en == currEnd) {
                    answer++;
                    continue;
                }

                currEnd = list.get(i).en;
                answer++;
                break;
            }
        } while (pos < list.size() - 1);
        System.out.println(answer);
    }
}
