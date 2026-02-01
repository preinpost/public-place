package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 쿼드트리
 */
public class B1992 {

    static int[] di = {0, 0, 1, 1};
    static int[] dj = {0, 1, 0, 1};

    int n, checkZero;
    int[][] arr;
    StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        B1992 T = new B1992();

        T.input();
        T.search(0, 0, T.n);
        if (T.checkZero == T.n * T.n) System.out.println(0);
        else if (T.checkZero == 0) System.out.println(1);
        else System.out.println(T.answer);
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        arr = new int[n][n];
        checkZero = 0;

        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            for (int j = 0; j < s.length(); j++) {
                int current = Integer.parseInt(s.substring(j, j + 1));
                if (current == 0) checkZero++;
                arr[i][j] = current;
            }
        }
    }

    public void search(int sI, int sJ, int depth) {
        answer.append("(");
        if (depth == 1) return;

        int half = depth / 2;

        for (int i = 0; i < 4; i++) {
            int nI = sI + (di[i] * half);
            int nJ = sJ + (dj[i] * half);

            if (!partialSearch(nI, nJ, half)) search(nI, nJ, half);
            else {
                answer.append(arr[nI][nJ]);
            }
        }
        answer.append(")");
    }

    public boolean partialSearch(int nI, int nJ, int move) {
        for (int j = nI; j < nI + move; j++) {
            for (int k = nJ; k < nJ + move; k++) {
                if (arr[nI][nJ] != arr[j][k]) {
                    return false;
                }
            }
        }
        return true;
    }
}
