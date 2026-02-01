package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class B2805 {

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        s = bf.readLine();
        st = new StringTokenizer(s);

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArr = IntStream.of(arr).sorted().toArray();


        long p1 = 0;
        long p2 = sortedArr[sortedArr.length-1];
        long max = 0;

        while (p1 < p2) {
            long mid = (p1 + p2) / 2;

            long result = Arrays.stream(sortedArr).mapToLong(item -> {
                if ((item - mid) < 0) return 0;
                return (item - mid);
            }).sum();

            if (result >= m) {
                // 하계
                p1 = mid+1;
                max = mid;
            } else {
                // 상계
                p2 = mid;
            }
        }
        System.out.println(max);
    }
}
