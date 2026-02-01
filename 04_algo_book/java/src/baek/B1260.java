package baek;

import java.util.*;

public class B1260 {

    static List<List<Integer>> arr = new ArrayList<>();
    static int[] visited_dfs;
    static int[] visited_bfs;

    public static void main(String[] args) {

        B1260 T = new B1260();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int v = in.nextInt();

        visited_dfs = new int[n+1];
        visited_bfs = new int[n+1];

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        for (List<Integer> integers : arr) {
            Collections.sort(integers);
        }

        T.solution(v);
    }

    private void solution(int v) {
        DFS(v);
        System.out.println();
        BFS(v);
    }

    private void DFS(int v) {

        if (visited_dfs[v] == 1) return;
        System.out.print(v + " ");
        visited_dfs[v] = 1;

        for (Integer vex : arr.get(v)) {
            DFS(vex);
        }
    }

    private void BFS(int v) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(v);

        while (!q.isEmpty()) {
            Integer current = q.poll();
            if (visited_bfs[current] == 1) continue;
            System.out.print(current + " ");
            visited_bfs[current] = 1;

            for (Integer vex : arr.get(current)) {
                q.offer(vex);
            }
        }
    }
}
