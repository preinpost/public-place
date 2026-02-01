package lecture.L06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class L0605 {

    public void solution(int n, int[] arr) {

        Map<Integer, String> map = new HashMap<>();

        for (int i : arr) {
            if (map.containsKey(i)) {
                System.out.println("D");
                return;

            }

            map.put(i, "");
        }

        System.out.println("U");

    }

    public static void main(String[] args) {

        L0605 T = new L0605();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        T.solution(n, arr);

    }
}
