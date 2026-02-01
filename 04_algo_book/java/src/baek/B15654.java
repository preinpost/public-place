package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B15654 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        String[] split = s.split(" ");

        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        s = bf.readLine();
        split = s.split(" ");

        int[] arr = new int[n];
        int[] candid = new int[m];
        int[] used = new int[n];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(arr);

        backtracking(arr, candid, used, 0, m);

    }

    static void backtracking(int[] arr, int[] candid, int[] used, int candidIdx, int m) {
        if (candidIdx == m) {
            // 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(candid[i]);
                sb.append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i] != 1) {
                candid[candidIdx] = arr[i];
                used[i] = 1;
                backtracking(arr, candid, used, candidIdx + 1, m);
                used[i] = 0;
            }
        }
    }
}
