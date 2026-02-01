package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 체스판 다시 칠하기
 */
public class B1018 {

    char[][] arr;
    int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        B1018 b1018 = new B1018();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();

        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로

        b1018.arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            s = bf.readLine();
            for (int j = 0; j < m; j++) {
                b1018.arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b1018.find(i, j, n, m);
            }
        }

        System.out.println(b1018.answer);
    }


    public void find(int i, int j, int n, int m) {
        if (i + 8 > n || j + 8 > m) return;

        int white_first = 0;
        int black_first = 0;

        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {

                if ((k + l) % 2 == 0) {
                    if (arr[k][l] != 'W') {
                        white_first++;
                    }
                } else {
                    if (arr[k][l] != 'B') {
                        white_first++;
                    }
                }

                if ((k + l) % 2 == 0) {
                    if (arr[k][l] != 'B') {
                        black_first++;
                    }
                } else {
                    if (arr[k][l] != 'W') {
                        black_first++;
                    }
                }
            }
        }

        int candid = Math.min(white_first, black_first);
        answer = Math.min(answer, candid);
    }
}
