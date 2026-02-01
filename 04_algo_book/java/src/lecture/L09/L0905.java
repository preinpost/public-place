package lecture.L09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class L0905 {

    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    static class Edge implements Comparable<Edge> {
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public void solution(int v) {
        PriorityQueue<Edge> PQ = new PriorityQueue<>();
        PQ.offer(new Edge(v, 0));
        dis[v] = 0;

        while (!PQ.isEmpty()) {
            Edge tmp = PQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;

            if (nowCost > dis[now]) continue;
            for (Edge ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    PQ.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }

    }

    public static void main(String[] args) {

        L0905 T = new L0905();

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();

        for (int i = 0; i <=n; i++) {
            graph.add(new ArrayList<Edge>());
        }

        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        T.solution(1);
        for (int i = 2; i <=n; i++) {
            if (dis[i] != Integer.MAX_VALUE) System.out.println(i + " " + dis[i]);
            else System.out.println(i + " : impossible");
        }

    }
}
