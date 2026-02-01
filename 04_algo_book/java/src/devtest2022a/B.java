package devtest2022a;

public class B {

    /*
        해당칸이 몇번째로 청소되었는지 return 해야함
     */

    public static void main(String[] args) {

        B b = new B();

        int n = 4;
        boolean horizontal = true;

        int[][] solution = b.solution(n, horizontal);
    }

    public int[][] solution(int n, boolean horizontal) {
        int[][] answer = new int[n][n];
        answer[0][0] = 1;

        int sequence = 2;
        int max = 2;

        int di;
        int dj;
        int pos_i = 0;
        int pos_j = 0;

        if (horizontal) {
            pos_j = 1;
        } else {
            pos_i = 1;
        }

        while (sequence < n*n) {

            if (horizontal) {
                di = 1;
                dj = -1;
            } else {
                di = -1;
                dj = 1;
            }

            for (int k = 0; k < max*max - (max-1)*(max-1); k++) {

                if (horizontal) {

                    if ((pos_i + di) < max) {
                        answer[pos_i][pos_j] = sequence++;
                        pos_i += di;
                    }
                    else {
                        answer[pos_i][pos_j] = sequence++;
                        pos_j += dj;
                    }


                } else {

                    if ((pos_j+ dj) < max) {
                        answer[pos_i][pos_j] = sequence++;
                        pos_j += dj;
                    }
                    else {
                        answer[pos_i][pos_j] = sequence++;
                        pos_i += di;
                    }
                }

            }

            max++;

            if (horizontal) {
                pos_i += 1;
                pos_j = 0;
            }
            else {
                pos_j += 1;
                pos_i = 0;
            }

            horizontal = !horizontal;
        }

        return answer;
    }

}
