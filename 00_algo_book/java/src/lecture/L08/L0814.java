package lecture.L08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class L0814 {

    static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[] di = {1, 0, -1, 0, 1, -1, 1, -1};
    static int[] dj = {0, 1, 0, -1, 1, -1, -1, 1};
    static int[][] dis;
    static int answer = 0;

    public void solution(int n, int[][] arr) {
        dis = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    answer++;
                    BFS(new Node(i, j), n, arr);
                }
            }
        }

        System.out.println(answer);

    }

    public void BFS(Node sNode, int n, int[][] arr) {

        Queue<Node> Q = new LinkedList<>();
        Q.offer(sNode);

        while (!Q.isEmpty()) {

            Node current = Q.poll();
            arr[current.i][current.j] = 0;

            for (int k = 0; k < 8; k++) {
                int ni = current.i + di[k];
                int nj = current.j + dj[k];

                if (ni < 0 || ni >= n || nj <0 || nj >= n || arr[ni][nj] ==0) continue;

                Q.offer(new Node(ni, nj));
                dis[ni][nj] = dis[current.i][current.j] + 1;

            }


        }


    }

    public static void main(String[] args) {

        L0814 T = new L0814();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int [][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        T.solution(n, arr);
    }
}
