package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 행렬 곱셈
public class B2740 {

    int[][] A;
    int[][] B;

    public static void main(String[] args) throws IOException {
        B2740 T = new B2740();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        T.A = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);

            while (st.hasMoreTokens()) {
                for (int j = 0; j < m; j++) {
                    T.A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        s = bf.readLine();
        st = new StringTokenizer(s);

        Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        T.B = new int[m][k];

        for (int i = 0; i < m; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);

            while (st.hasMoreTokens()) {
                for (int j = 0; j < k; j++) {
                    T.B[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int[][] result = T.multiple(n, k, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    int[][] multiple(int n, int k, int m) {
        int[][] newMatrix = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int sum = 0;
                for (int l = 0; l < m; l++) {
                    sum += A[i][l] * B[l][j];
                }

                newMatrix[i][j] = sum;
            }
        }

        return newMatrix;
    }


}
