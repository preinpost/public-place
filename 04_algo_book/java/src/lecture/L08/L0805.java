package lecture.L08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L0805 {

    static class State {
        int min = Integer.MAX_VALUE;
        int sum = 0;
    }

    public void solution(int n, int[] arr, int m) {

        State state = new State();

        List<Integer> list = Arrays.stream(arr).sorted().boxed().collect(Collectors.toList());
        list.sort(Comparator.reverseOrder());

        DFS(0, state, n, list, m);
        System.out.println(state.min);

    }

    public void DFS(int level, State state, int n, List<Integer> arr, int m) {
        if (state.sum > m) return;
        if (level >= state.min) return;

        if (state.sum == m) {
            state.min = Math.min(state.min, level);
            return;
        }

        for (int i = 0; i < n; i++) {
            state.sum += arr.get(i);
            DFS(level+1, state, n, arr, m);
            state.sum -= arr.get(i);
        }
    }

    public static void main(String[] args) {

        L0805 T = new L0805();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int m = in.nextInt();

        T.solution(n, arr, m);
    }
}
