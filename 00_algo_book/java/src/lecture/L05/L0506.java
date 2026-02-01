package lecture.L05;

import java.util.ArrayList;
import java.util.Scanner;

public class L0506 {

    public  ArrayList<Integer> solution(int n, int k) {

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        while (arr.size() > 1) {
            int cnt = 1;

            while (cnt < k) {
                arr.add(arr.remove(0));
                cnt++;
            }

            arr.remove(0);
        }

        return arr;

    }

    public static void main(String[] args) {

        L0506 T = new L0506();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        System.out.println(T.solution(n, k).remove(0));
    }
}
