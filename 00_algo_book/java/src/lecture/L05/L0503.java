package lecture.L05;

import java.util.ArrayList;
import java.util.Scanner;

public class L0503 {

    public void solution(int n, ArrayList<ArrayList<Integer>> arrStack, int m, int[] moves) {

        int answer = 0;
        ArrayList<Integer> scoreStk = new ArrayList<>();

        int p1 = 0;

        while (p1 < m) {
            Integer poppedItem = null;
            int idx = 0;
            for (Integer l : arrStack.get(moves[p1])) {

                if (l == 0) {
                    idx++;
                    continue;
                }

                poppedItem = l;
                arrStack.get(moves[p1]).set(idx, 0);
                break;
            }

            if (poppedItem == null) {
                p1++;
                continue;
            }

            scoreStk.add(poppedItem);

            if (scoreStk.size() > 1 && poppedItem.equals(scoreStk.get(scoreStk.size() - 2))) {
                scoreStk.remove(scoreStk.size()-1);
                scoreStk.remove(scoreStk.size()-1);
                answer+=2;
            }

            p1++;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {

        L0503 T = new L0503();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> arrStack = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            arrStack.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                arrStack.get(j).add(in.nextInt());
            }
        }

        int m = in.nextInt();
        int[] moves = new int[m];

        for (int i = 0; i < m; i++) {
            moves[i] = in.nextInt();
        }

        T.solution(n, arrStack, m, moves);
    }
}
