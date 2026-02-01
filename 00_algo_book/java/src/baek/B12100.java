package baek;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class B12100 {

    static int[] dx = {1, 0, -1 ,0};
    static int[] dy = {0, 1, 0 ,-1};
    static int answer = -1;

    public static void main(String[] args) {

        B12100 b12100 = new B12100();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
                answer = Math.max(answer, map[i][j]);
            }
        }

        b12100.solution(n, map);
    }

    public void solution(int n, int[][] map) {

//        move(map, 3);
//        System.out.println();

        dfs(0, map);
        System.out.println(answer);
    }

    public void dfs(int level, int[][] map) {
        if (level > 5) return;

        for (int i = 0; i < 4; i++) {
            int[][] result = move(map, i);
            dfs(level+1, result);
        }
    }

    public int[][] move(int[][] map, int direction) {
        // direction : 0 - 오른쪽 시프트
        // direction : 1 - 아래 시프트
        // direction : 2 - 왼쪽 시프트
        // direction : 3 - 위 시프트

        int[][] copy = new int[map.length][map.length];


        switch (direction) {
            case 0: // 오른쪽 시프트
                for (int i = 0; i < map.length; i++) {
                    Stack<Integer> stk = new Stack<>();
                    boolean flag = false;

                    for (int j = 0; j < map.length; j++) {
                        if (map[i][j] == 0) continue;

                        if (stk.isEmpty()) {
                            stk.add(map[i][j]);
                            continue;
                        }

                        if (!flag && stk.peek() == map[i][j]) {
                            stk.add(stk.pop() + map[i][j]);
                            flag = true;
                        } else if (flag && stk.peek() == map[i][j]) {
                            stk.add(map[i][j]);
                        } else {
                            stk.add(map[i][j]);
                            flag = false;
                        }
                    }

                    int size = stk.size();

                    for (int j = 0; j < map.length; j++) {
                        if (size-1 <= j) {
                            copy[i][j] = stk.pop();
                        } else {
                            copy[i][j] = 0;
                        }

                    }
                }
                break;

            case 1: // 아래 시프트
                for (int j = 0; j < map.length; j++) {
                    Stack<Integer> stk = new Stack<>();
                    boolean flag = false;

                    for (int i = 0; i < map.length; i++) {
                        if (map[i][j] == 0) continue;

                        if (stk.isEmpty()) {
                            stk.add(map[i][j]);
                            continue;
                        }

                        if (!flag && stk.peek() == map[i][j]) {
                            stk.add(stk.pop() + map[i][j]);
                            flag = true;
                        } else if (flag && stk.peek() == map[i][j]) {
                            stk.add(map[i][j]);
                        } else {
                            stk.add(map[i][j]);
                            flag = false;
                        }
                    }

                    int size = stk.size();

                    for (int i = 0; i < map.length; i++) {
                        if (size-1 <= i) {
                            copy[i][j] = stk.pop();
                        } else {
                            copy[i][j] = 0;
                        }

                    }
                }
                break;

            case 2: // 왼쪽 시프트
                for (int i = 0; i < map.length; i++) {
                    Stack<Integer> stk = new Stack<>();
                    boolean flag = false;

                    for (int j = map.length-1; j >= 0; j--) {
                        if (map[i][j] == 0) continue;

                        if (stk.isEmpty()) {
                            stk.add(map[i][j]);
                            continue;
                        }

                        if (!flag && stk.peek() == map[i][j]) {
                            stk.add(stk.pop() + map[i][j]);
                            flag = true;
                        } else if (flag && stk.peek() == map[i][j]) {
                            stk.add(map[i][j]);
                        } else {
                            stk.add(map[i][j]);
                            flag = false;
                        }
                    }

                    int size = stk.size();

                    for (int j = map.length-1; j >= 0; j--) {
                        if (size-1 >= j) {
                            copy[i][j] = stk.pop();
                        } else {
                            copy[i][j] = 0;
                        }
                    }
                }
                break;

            case 3: // 위 시프트
                for (int j = 0; j < map.length; j++) {
                    Stack<Integer> stk = new Stack<>();
                    boolean flag = false;

                    for (int i = map.length-1; i >= 0; i--) {
                        if (map[i][j] == 0) continue;

                        if (stk.isEmpty()) {
                            stk.add(map[i][j]);
                            continue;
                        }

                        if (!flag && stk.peek() == map[i][j]) {
                            stk.add(stk.pop() + map[i][j]);
                            flag = true;
                        } else if (flag && stk.peek() == map[i][j]) {
                            stk.add(map[i][j]);
                        } else {
                            stk.add(map[i][j]);
                            flag = false;
                        }
                    }

                    int size = stk.size();

                    for (int i = map.length-1; i >= 0; i--) {
                        if (size-1 >= i) {
                            copy[i][j] = stk.pop();
                        } else {
                            copy[i][j] = 0;
                        }

                    }
                }
                break;

            default:
                break;
        }




        return copy;
    }
}
