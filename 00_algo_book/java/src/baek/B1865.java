package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1865 {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {
        B1865 T = new B1865();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());

        for (int i = 0; i < tc; i++) {
            T.solution(bf);
        }




    }

    void solution(BufferedReader bf) throws IOException {
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        PriorityQueue<Pair> loadPQ = new PriorityQueue<>((o1, o2) -> o1.second - o2.second); // minHeap
        PriorityQueue<Pair> warmPQ = new PriorityQueue<>((o1, o2) -> o2.second - o1.second); // maxHeap

        int[] dij = new int[n + 1];
        int[] check = new int[n + 1];

        List<List<Pair>> roadList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            roadList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);

            int ss = Integer.parseInt(st.nextToken());
            int ee = Integer.parseInt(st.nextToken());
            int tt = Integer.parseInt(st.nextToken());

            roadList.get(ss).add(new Pair(ee, tt));
            roadList.get(ee).add(new Pair(ss, tt));
        }

        for (int i = 0; i < w; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);

            int ss = Integer.parseInt(st.nextToken());
            int ee = Integer.parseInt(st.nextToken());
            int tt = Integer.parseInt(st.nextToken());

        }







    }

}
