package lecture.L05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class L0508 {

    public void solution(int n, int m, int[] arr) {

        Queue<Member> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            queue.offer(new Member(arr[i], i));
        }

        int cnt = 0;
        Member current = queue.poll();

        while (true) {
            boolean flag = false;

            for (Member member : queue) {
                if (current.compareTo(member) < 0) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                queue.offer(current);
                current = queue.poll();
            } else {
                cnt++;
                if (current.wait == m) {
                    System.out.println(cnt);
                    break;
                }
                current = queue.poll();
            }
        }
    }

    public static void main(String[] args) {

        L0508 T = new L0508();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        T.solution(n, m, arr);
    }


    static class Member implements Comparable<Member>{
        final int dmg;
        final int wait;

        public Member(int dmg, int wait) {
            this.dmg = dmg;
            this.wait = wait;
        }


        @Override
        public int compareTo(Member o) {
            return this.dmg - o.dmg;
        }

        @Override
        public String toString() {
            return "dmg : " + this.dmg + " wait : " + this.wait;
        }
    }
}
