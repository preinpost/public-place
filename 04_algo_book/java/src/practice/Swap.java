package practice;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Swap {

    public static void main(String[] args) {

        int[] arr = {3, 7, 2, 8, 6, 4, 5, 1};
        int k = 3;

        List<Pair> diffList = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            diffList.add(new Pair(Math.abs(arr[i - 1] - arr[i]), i - 1));
        }


        while (true) {
            Collections.sort(diffList);

            if (diffList.get(0).diff <= k) return;


        }







    }

    boolean isSwappable(Pair pair1, Pair pair2, int[] arr, int k) {
        int pair1Max = Math.max(arr[pair1.idx], arr[pair1.idx + 1]);
        int pair1Min = Math.max(arr[pair1.idx], arr[pair1.idx + 1]);

        int pair2Max = Math.min(arr[pair2.idx], arr[pair2.idx + 1]);
        int pair2Min = Math.max(arr[pair2.idx], arr[pair2.idx + 1]);



        return false;
    }

    static class Pair implements Comparable<Pair> {
        int diff, idx;

        Pair(int diff, int idx) {
            this.diff = diff;
            this.idx = idx;
        }

        @Override
        public int compareTo(@NotNull Pair o) {
            return  o.diff - this.diff;
        }
    }
}
