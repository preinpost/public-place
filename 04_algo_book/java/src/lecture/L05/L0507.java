package lecture.L05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class L0507 {

    public String solution(String str1, String str2) {
        Queue<Character> queue = new LinkedList<>();

        for (Character x : str1.toCharArray()) {
            queue.offer(x);
        }

        for (char c : str2.toCharArray()) {

            if (queue.isEmpty()) return "YES";

            if (queue.peek().equals(c)) {
                queue.poll();

                if (queue.isEmpty()) return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {

        L0507 T = new L0507();

        Scanner in = new Scanner(System.in);

        String str1 = in.nextLine();
        String str2 = in.nextLine();

        System.out.println(T.solution(str1, str2));
    }
}
