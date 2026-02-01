package lecture.L08;

import java.util.Scanner;

public class L0806 {

    static public class State {

        int[] chk;
        int[] answer;

        public State(int n, int m) {
            chk = new int[n];
            answer = new int[m];
        }
    }

    public void solution(int n, int m, int[] arr) {

        State state = new State(n, m);
        DFS(0, state, n, m, arr);

    }

    public void DFS(int level, State state, int n, int m, int[] arr) {

        if (level == m) {

            for (int a : state.answer) {
                System.out.print(a + " ");
            }
            System.out.println();

            return;
        }

        for (int i = 0; i < n; i++) {

            if (state.chk[i] == 1) continue;

            state.answer[level] = arr[i];
            state.chk[i] = 1;
            DFS(level+1, state, n, m, arr);
            state.chk[i] = 0;
        }


    }

    public static void main(String[] args) {

        L0806 T = new L0806();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
         arr[i] = in.nextInt();
        }

        T.solution(n, m, arr);
    }
}
