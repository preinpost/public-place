package programmers.book.P03;

// P03. 거리두기 확인하기
import java.util.*;

class Solution {

    static int[] di = new int[]{1, 0, -1, 0};
    static int[] dj = new int[]{0, 1, 0, -1};

    static class Pos {
        int i;
        int j;

        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx = 0;

        for (String[] place : places) {
            Queue<Pos> Q = new LinkedList<>();
            char[][] map = new char[5][5];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    map[i][j] = place[i].charAt(j);

                    if (place[i].charAt(j) == 'P') {
                        Q.offer(new Pos(i, j));
                    }
                }
            }

            boolean result = true;
            int size = Q.size();

            for (int k = 0; k < size; k++) {
                Pos poll = Q.poll();

                result = run(poll, map);

                if (result == false) {
                    break;
                }
            }

            if (result == true) {
                answer[idx] = 1;
            }

            idx += 1;
        }
        return answer;
    }

    private boolean run(Pos startPos, char[][] map) {
        Queue<Pos> Q = new LinkedList<>();
        int[][] visited = new int[5][5];
        Q.offer(startPos);

        int d = 1;
        while (!Q.isEmpty() || d < 3) {
            int size = Q.size();

            for (int k = 0; k < size; k++) {
                Pos poll = Q.poll();
                visited[poll.i][poll.j] = 1;

                for (int i = 0; i < 4; i++) {
                    int nextI = poll.i + di[i];
                    int nextJ = poll.j + dj[i];

                    if (isValid(nextI, nextJ) == false || map[nextI][nextJ] == 'X') continue;
                    if (visited[nextI][nextJ] == 1) continue;
                    if (d <= 2 && map[nextI][nextJ] == 'P') return false;
                    Q.offer(new Pos(nextI, nextJ));
                }
            }
            d += 1;
        }

        return true;
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && j >= 0 && i < 5 && j < 5;
    }
}
