package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A06 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();

        String[] split = s.split(" ");
        int n = Integer.parseInt(split[0]);
        int q = Integer.parseInt(split[1]);


        int[] arr = new int[n + 1];

        s = bf.readLine();
        split = s.split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(split[i - 1]);
        }


        for (int i = 0; i < q; i++) {
            s = bf.readLine();
            split = s.split(" ");

            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);

            System.out.println(arr[end] - arr[start - 1]);
        }
    }
}
