package lecture.L06;

import java.util.*;

public class L0607 {

    public void solution(int n, List<V> list) {

        Collections.sort(list);


        for (V v : list) {
            System.out.println(v.getX() + " " + v.getY());
        }
    }

    public static void main(String[] args) {

        L0607 T = new L0607();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        List<V> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new V(in.nextInt(), in.nextInt()));
        }

        T.solution(n, list);
    }

    static class V implements Comparable<V>{

        private int x;
        private int y;

        public V(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(V o) {
            if (this.getX() == o.getX()) {
                return this.getY() - o.getY();
            }

            return this.getX() - o.getX();
        }
    }
}
