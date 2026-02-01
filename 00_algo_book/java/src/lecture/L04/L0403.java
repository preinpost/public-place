package lecture.L04;

import java.util.HashMap;
import java.util.Scanner;

public class L0403 {

    public void solution(int n, int k, int[] arr) {

        int p1 = 0;
        int p2 = k-1;
        HashMap<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i <= p2; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        }

        System.out.print(map.keySet().size() + " ");

        while (p2 < n-1) {
            map.put(arr[p1], map.get(arr[p1])-1);
            if (map.get(arr[p1]) == 0) map.remove(arr[p1]);
            p1++;

            p2++;
            map.put(arr[p2], map.getOrDefault(arr[p2], 0)+1);

            System.out.print(map.keySet().size() + " ");
        }

    }

    public static void main(String[] args) {

        L0403 T = new L0403();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        T.solution(n, k, arr);
    }
}
