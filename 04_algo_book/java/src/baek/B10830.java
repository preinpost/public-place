package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 행렬 제곱
public class B10830 {

    static class Matrix {
        int[][] mtx;

        public Matrix(int n) {
            this.mtx = new int[n][n];
        }

        void addMatrixValue(int i, int j, int value) {
            this.mtx[i][j] = value;
        }
    }

    Matrix origin;

    public static void main(String[] args) throws IOException {
        B10830 T = new B10830();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        T.origin = new Matrix(n);

        for (int i = 0; i < n; i++) {
            int idx = 0;
            s = bf.readLine();
            st = new StringTokenizer(s);

            while (st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                T.origin.addMatrixValue(i, idx, value);
                idx += 1;
            }
        }

        Matrix result = T.calculateMatrix(0, T.origin, n, b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result.mtx[i][j] + " ");
            }
            System.out.println();
        }

    }

    Matrix calculateMatrix(int depth, Matrix matrix, int n, long b) {
        if (depth == b - 1) return matrix;

        Matrix newMatrix = new Matrix(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;

                for (int k = 0; k < n; k++) {
                    sum += (matrix.mtx[i][k] * origin.mtx[k][j]);
                }

                newMatrix.addMatrixValue(i, j, sum % 1000);
            }
        }

        return calculateMatrix(depth + 1, newMatrix, n, b);
    }
}
