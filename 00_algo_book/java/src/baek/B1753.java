package baek;

import java.util.*;

public class B1753 {

    static class Edge implements Comparable<Edge> {
        int v;
        int c;

        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }

    public static void main(String[] args) {

        B1753 b1753 = new B1753();

        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();
        int sV = in.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        int[] dis = new int[v+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < e; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            graph.get(a).add(new Edge(b, c));
        }

        b1753.solution(sV, dis, graph);
    }

    public void solution(int sV, int[] dis, List<List<Edge>> graph) {

        PriorityQueue<Edge> Q = new PriorityQueue<>();
        Q.offer(new Edge(sV, 0));
        dis[sV] = 0;

        while (!Q.isEmpty()) {

            Edge poll = Q.poll();

            if (poll.c > dis[poll.v]) continue;

            for (Edge e : graph.get(poll.v)) {

                if (dis[e.v] > poll.c + e.c) {
                    dis[e.v] = poll.c + e.c;
                    Q.offer(new Edge(e.v, poll.c + e.c));
                }
            }
        }

        for (int i = 1; i < dis.length; i++) {
            if (dis[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dis[i]);
        }
    }
}
