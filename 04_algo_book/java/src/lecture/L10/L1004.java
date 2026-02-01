package lecture.L10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Brick implements Comparable<Brick> {
    int area;
    int height;
    int weight;

    public Brick(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick o) {
        return o.area - this.area;
    }
}

public class L1004 {

    static List<Brick> arr = new ArrayList<>();
    static int[] dy;

    public void solution(int n) {
        Collections.sort(arr);
        int answer = 0;

        dy[0] = arr.get(0).height;
        answer = dy[0];

        for (int i = 1; i < n; i++) {
            int max_h = 0;
            for (int j = i-1; j >= 0; j--) {
                if (arr.get(j).weight > arr.get(i).weight && dy[j] > max_h) {
                    max_h = dy[j];
                }
            }
            dy[i] = max_h + arr.get(i).height;
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {

        L1004 T = new L1004();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        dy = new int[n];

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            arr.add(new Brick(a, b, c));
        }

        T.solution(n);
    }
}
