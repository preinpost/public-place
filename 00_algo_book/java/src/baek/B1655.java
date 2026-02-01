package baek;

import java.util.*;

public class B1655 {

    public static void main(String[] args) {


        /*
            1. 말한 수 중 중간값
            2. 외친 수의 개수가 짝수이면 중간에 있는 두 수 중 작은 수를 말해야 함

            입력이
            1 5 2 10 -99 7 5 일 때

            1일 때 1
            1 5 일 때 1
            1 5 2 일때 2
            1 5 2 10 일때 2
            1 5 2 10 -99 일때 2
            1 5 2 10 -99 7 일때
                -> -99 1 2 5 7 10 = 2
            1 5 2 10 -99 7 5 일때
                -> -99 1 2 5 5 7 10 = 5

         */

        B1655 b1655 = new B1655();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        StringBuffer sb = new StringBuffer();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int sol = b1655.solution(a, minHeap, maxHeap);
            sb.append(sol + "\n");
        }

        System.out.println(sb);
    }

    private int solution(int n, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.size() == maxHeap.size()) {
            // maxHeap에 입력
            maxHeap.add(n);
        } else {
            minHeap.add(n);
        }

        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int tmp = maxHeap.poll();
            maxHeap.add(minHeap.poll());
            minHeap.add(tmp);
        }

        if (!maxHeap.isEmpty()) return maxHeap.peek();
        else return minHeap.peek();
    }
}
