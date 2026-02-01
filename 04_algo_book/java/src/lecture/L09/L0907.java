package lecture.L09;

import java.util.*;

public class L0907 {

    static List<Edge> arr= new ArrayList<>();
    static int[] group;
    static int answer = 0;

    static class Edge implements Comparable<Edge> {
        int v1; // vertex1
        int v2; // vertex2
        int c; // cost

        public Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return o.c - this.c;
        }
    }

    public void solution() {

        arr.sort(Collections.reverseOrder());

        for (Edge edge : arr) {

            if (find(edge.v1) != find(edge.v2)) {
                answer += edge.c;
                union(edge.v1, edge.v2);
            }
        }

        System.out.println(answer);
    }

    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa < fb)
            group[fb] = fa;
        else
            group[fa] = fb;
    }

    public int find(int v) {
        if (v == group[v]) return v;
        else return group[v] = find(group[v]);
    }

    public static void main(String[] args) {

        L0907 T = new L0907();

        Scanner in = new Scanner(System.in);

        int v = in.nextInt();
        int e = in.nextInt();

        group = new int[v+1];

        for (int i = 0; i <= v; i++) {
            group[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            arr.add(new Edge(a, b, c));
        }

        T.solution();
    }
}
