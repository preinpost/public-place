package lecture.L08;

import java.util.*;

public class L0812 {

    static public class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    int[] di = {0, 1, 0, -1};
    int[] dj = {1, 0, -1, 0};

    public void solution(int n, int m, int[][] map, Queue<Node> startList, int alwaysZeroCnt) {

        BFS(n, m, map, startList, alwaysZeroCnt);
    }

    public void BFS(int n, int m, int[][] map, Queue<Node> startList, int alwaysZeroCnt) {

        Queue<Node> Q = new LinkedList<>();
        int[][] dis = new int[n][m];
        int answer = Integer.MIN_VALUE;

        while (!startList.isEmpty()) {
            Q.offer(startList.poll());
        }

        while (!Q.isEmpty()) {
            Node current = Q.poll();

            for (int l = 0; l < 4; l++) {
                int next_i = current.i + di[l];
                int next_j = current.j + dj[l];

                if (next_i >= 0 && next_i < n && next_j >= 0 && next_j < m && map[next_i][next_j] == 0) {
                    map[next_i][next_j] = 1;
                    dis[next_i][next_j] = dis[current.i][current.j] + 1;
                    Q.offer(new Node(next_i, next_j));
                }
            }
        }

        int zeroCnt = 0;

        for (int[] ints : dis) {
            for (int anInt : ints) {
                if (anInt == 0) zeroCnt++;
                answer = Math.max(answer, anInt);
            }
        }



        if (alwaysZeroCnt == zeroCnt) System.out.println(answer);
        else if (answer == 0) System.out.println(0);
        else System.out.println(-1);

    }

    public static void main(String[] args) {

        L0812 T = new L0812();

        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        int[][] map = new int[n][m];
        Queue<Node> startList = new LinkedList<>();
        int alwaysZeroCnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int next = in.nextInt();
                if (next == 1) {
                    startList.offer(new Node(i, j));
                    alwaysZeroCnt++;
                }

                if (next == -1) alwaysZeroCnt++;

                map[i][j] = next;
            }
        }

        T.solution(n, m, map, startList, alwaysZeroCnt);
    }
}
