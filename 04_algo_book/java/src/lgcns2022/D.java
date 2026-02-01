package lgcns2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D {

    public static void main(String[] args) {
        D T = new D();

        int[][] edges = new int[][] {{1, 3}, {1, 2}, {2, 4}, {2, 5}};
        int[] roots = new int[]{2, 3};

        T.solution(edges, roots);

    }


    public int[] solution(int[][] edges, int[] roots) {
        int[] answer = {};

        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reverseGraph = new ArrayList<>();

        int n = edges.length + 1;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            reverseGraph.get(b).add(a);
        }

        for (int root : roots) {

            Queue<Integer> Q = new LinkedList<>();
            Q.offer(root);



            while (!Q.isEmpty()) {

                Integer poll = Q.poll();
                List<Integer> candid;

                if (graph.get(poll).isEmpty()) {
                    candid = reverseGraph.get(poll);

                    if (candid.isEmpty()) continue;

                    for (Integer integer : candid) {

                        Q.offer(integer);
                    }




                } else {




                    candid = graph.get(poll);
                }


            }
        }

        return answer;

    }

}
