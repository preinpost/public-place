package baek;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B1927 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        PriorityQueue<Integer> PQ = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int currentInt = in.nextInt();

            if (currentInt == 0) {

                if (!PQ.isEmpty()) {
                    System.out.println(PQ.poll());
                } else {
                    System.out.println(0);
                }

            } else {
                PQ.offer(currentInt);

            }
        }

    }
}
