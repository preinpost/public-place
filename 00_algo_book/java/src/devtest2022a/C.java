package devtest2022a;

public class C {

    /*
        가장 좁은 호수의 넓이
        가장 넓은 호수의 넓이
        호수가 존재하지 않을수도 있다
        육지에 둘러 싸여 있으면 호수이다.
     */

    public static void main(String[] args) {
        C c = new C();

        int rows = 9;
        int columns = 7;
        int[][] lands = new int[][] {{2, 2}, {2, 3}, {2, 5}, {3, 2}, {3, 4}, {3, 5}, {3, 6}, {4, 3}, {4, 6}, {5, 2}, {5, 5}, {6, 2}, {6, 3}, {6, 4}, {6, 6}, {7, 2}, {7, 6}, {8, 3}, {8, 4}, {8, 5}};

        c.solution(rows, columns, lands);
    }

    public int[] solution(int rows, int columns, int[][] lands) {
        int[] answer = {};
        int[][] map = new int[rows][columns];

        for (int[] land : lands) {
            map[land[0]-1][land[1]-1] = 1;
        }


//        for (int i = 0; i < columns; i++) {
//            map[0][i] = 2;
//            map[rows-1][i] = 2;
//        }
//
//        for (int i = 0; i < rows; i++) {
//            map[i][0] = 2;
//            map[i][columns-1] = 2;
//        }


        return answer;
    }

    public void recursive(int[][] map) {

    }
}
