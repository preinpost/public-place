package lecture.L05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class L0508_test {

    public int solution(int n, int m, int[] arr) {

        Queue<Member> queue = new LinkedList<>();
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            queue.offer(new Member(arr[i], i));
        }

        while (!queue.isEmpty()) {
            Member tmp = queue.poll();
            for (Member x : queue) {
                if (x.dmg > tmp.dmg) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }

            if (tmp !=null) {
                cnt++;
                if (tmp.wait == m) return cnt;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

        L0508_test T = new L0508_test();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int sol = T.solution(n, m, arr);
        System.out.println(sol);
    }


    static class Member{
        final int dmg;
        final int wait;

        public Member(int dmg, int wait) {
            this.dmg = dmg;
            this.wait = wait;
        }
    }
}
