package lecture.L08;

import java.util.ArrayList;
import java.util.Scanner;

public class L0815 {

    static class Node {
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static class State {
        ArrayList<Node> homeNodes = new ArrayList<>();
        ArrayList<Node> pizzaNodes = new ArrayList<>();
        ArrayList<Node> list = new ArrayList<>();
        int answer = Integer.MAX_VALUE;
    }

    public void solution(int n, int m, State state, int[][] arr) {

        getCandidList(0, 0, n, m, state, arr);

        System.out.println(state.answer);

    }

    public void getDistance(State state) {

        int sum = 0;

        for (Node home : state.homeNodes) {
            int min = Integer.MAX_VALUE;

            for (Node pizza : state.list) {
                int dis = Math.abs(home.j - pizza.j) + Math.abs(home.i - pizza.i);
                min = Math.min(min, dis);

            }

            sum += min;
        }

        state.answer = Math.min(state.answer, sum);
    }

    public void getCandidList(int level, int start, int n, int m, State state, int[][] arr) {
        // DFS
        if (level == m) {
            getDistance(state);
            return;
        }


        for (int i = start; i < state.pizzaNodes.size();i++) {

            state.list.add(state.pizzaNodes.get(i));
            getCandidList(level+1, i+1, n, m, state, arr);
            state.list.remove(level);

        }
    }

    public static void main(String[] args) {

        L0815 T = new L0815();

        Scanner in = new Scanner(System.in);

        State state = new State();

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int inCome = in.nextInt();

                if (inCome == 1) {
                    state.homeNodes.add(new Node(i ,j));
                } else if (inCome == 2) {
                    state.pizzaNodes.add(new Node(i ,j));
                }

                arr[i][j] = inCome;
            }
        }

        T.solution(n, m, state, arr);
    }
}
