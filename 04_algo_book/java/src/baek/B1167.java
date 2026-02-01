package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 트리의 지름
public class B1167 {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    int[] range;
    Pair max = new Pair(-1 , -1);
    int[] visited;
    List<List<Pair>> graph;

    public static void main(String[] args) throws IOException {
        B1167 T = new B1167();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(bf.readLine());

        T.graph = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            T.graph.add(new ArrayList<>());
        }

        T.range = new int[v + 1];
        T.visited = new int[v + 1];

        for (int i = 0; i < v; i++) {
            String s = bf.readLine();
            StringTokenizer st = new StringTokenizer(s);

            int currentVertex = Integer.parseInt(st.nextToken());

            int next;
            while ((next = Integer.parseInt(st.nextToken())) != -1) {
                int range = Integer.parseInt(st.nextToken());

                T.graph.get(next).add(new Pair(currentVertex, range));
            }
        }

        T.find(1);

        T.range = new int[v + 1];
        T.visited = new int[v + 1];

        T.find(T.max.first);
        System.out.println(T.max.second);



    }

    void find(int vertex) {
        if (visited[vertex] == 1) return;

        List<Pair> vertexList = graph.get(vertex);
        visited[vertex] = 1;

        for (Pair pair : vertexList) {
            if (visited[pair.first] == 1) continue;
            range[pair.first] += range[vertex] + pair.second;
            if (max.second < range[pair.first]) {
                max = new Pair(pair.first, range[pair.first]);
            }

            find(pair.first);
        }
    }
}
