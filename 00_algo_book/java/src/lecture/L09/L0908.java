package lecture.L09;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class L0908 {

    static public class Edge implements Comparable<Edge> {
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static int[] visited;
    static int answer = 0;

    public void solution(int v) {
        PriorityQueue<Edge> PQ = new PriorityQueue<>();

        PQ.offer(new Edge(1, 0));

        while (!PQ.isEmpty()) {
            Edge tmp = PQ.poll();
            int now = tmp.vertex;
            int nowCost = tmp.cost;

            if (visited[now] == 1) continue;

            answer += nowCost;
            visited[now] = 1;

            for(Edge eg : graph.get(now)) {
                PQ.offer(new Edge(eg.vertex, eg.cost));
            }
        }

        System.out.println(answer);

    }

    public static void main(String[] args) {

        L0908 T = new L0908();

        Scanner in = new Scanner(System.in);

        int v = in.nextInt();
        int e = in.nextInt();

        visited = new int[v+1];

        for (int i = 0; i <= e; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        T.solution(1);
    }
}
