package lecture.L08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class L0811 {

    public static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }


    int[] di = {0, 1, -1, 0};
    int[] dj = {1, 0, 0, -1};


    public void solution(int[][] arr) {
        BFS(0, 0, arr);
    }

    public void BFS(int si, int sj, int[][] arr) {

        Node root = new Node(si, sj);
        Queue<Node> Q = new LinkedList<>();
        int[][] dis = new int[7][7];

        Q.offer(root);
        int L = 0;
        arr[0][0] = 1;

        while (!Q.isEmpty()) {


            Node current = Q.poll();

            for (int next = 0; next < 4; next++) {
                int next_i = current.i+di[next];
                int next_j = current.j+dj[next];

                if (next_i == 7 || next_j == 7 || next_i == -1 || next_j == -1) continue;

                if (arr[next_i][next_j] != 1) {
                    Q.offer(new Node(next_i, next_j));
                    arr[next_i][next_j] = 1;
                    dis[next_i][next_j] = dis[current.i][current.j] + 1;
                }

            }
        }
        if (dis[6][6] == 0) System.out.println(-1);
        else System.out.println(dis[6][6]);

    }

    public static void main(String[] args) {

        L0811 T = new L0811();

        Scanner in = new Scanner(System.in);

        int[][] arr = new int[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        T.solution(arr);
    }
}
