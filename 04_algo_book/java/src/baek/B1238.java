package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 파티
public class B1238 {

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return o.second - this.second;
        }
    }

    List<List<Pair>> graph = new ArrayList<>();
    List<List<Pair>> reversedGraph = new ArrayList<>();
    int n, m, x;

    public static void main(String[] args) throws IOException {
        B1238 T = new B1238();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        T.n = Integer.parseInt(st.nextToken());
        T.m = Integer.parseInt(st.nextToken());
        T.x = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= T.n; i++) {
            T.graph.add(new ArrayList<>());
            T.reversedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < T.m; i++) {
            s = bf.readLine();
            String[] split = s.split(" ");

            int one = Integer.parseInt(split[0]);
            int two = Integer.parseInt(split[1]);
            int three = Integer.parseInt(split[2]);

            T.graph.get(one).add(new Pair(two, three));
            T.reversedGraph.get(two).add(new Pair(one, three));
        }

        int result = T.calculate();
        System.out.println(result);
    }

    int calculate() {
        int dij[] = new int[n + 1];
        int reversedDij[] = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            dij[i] = Integer.MAX_VALUE;
            reversedDij[i] = Integer.MAX_VALUE;
        }

        search(x, dij, new int[n + 1], graph);
        search(x, reversedDij, new int[n + 1], reversedGraph);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            answer = Math.max(answer, dij[i] + reversedDij[i]);
        }

        return answer;
    }

    void search(int start, int[] dij, int[] visited, List<List<Pair>> graph) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dij[start] = 0;

        pq.offer(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair poll = pq.poll();

            if (visited[poll.first] == 1) continue;

            List<Pair> pairList = graph.get(poll.first);

            for (Pair pair : pairList) {
                if (dij[pair.first] > dij[poll.first] + pair.second) {
                    dij[pair.first] = dij[poll.first] + pair.second;
                    pq.offer(pair);
                }
            }
        }
    }
}
