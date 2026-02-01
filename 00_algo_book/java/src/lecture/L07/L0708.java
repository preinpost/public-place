package lecture.L07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class L0708 {

    Queue<Integer> Q = new LinkedList<>();
    int[] ways = new int[] {1, -1, 5};
    int[] ch;

    public int solution(int s, int e) {
        ch = new int[10001];
        ch[s]=1;
        Q.offer(s);
        int L = 0;
        int answer = -1;

        while (!Q.isEmpty()) {

            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();

                for (int way : ways) {
                    int nx = x + way;
                    if (nx == e) return answer = L + 1;
                    if (nx >=1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;


        }

        return answer;


    }

    public static void main(String[] args) {

        L0708 T = new L0708();

        Scanner in = new Scanner(System.in);

        int s = in.nextInt();
        int e = in.nextInt();

        System.out.println(T.solution(s, e));
    }
}
