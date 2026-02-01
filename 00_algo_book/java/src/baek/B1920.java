package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 수 찾기
 */
public class B1920 {

    public static void main(String[] args) throws IOException {
        B1920 T = new B1920();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr = IntStream.of(arr).sorted().toArray();

        int m = Integer.parseInt(bf.readLine());
        s = bf.readLine();
        st = new StringTokenizer(s);

        while (st.hasMoreTokens()) {
            int result = T.find(Integer.parseInt(st.nextToken()), arr);
            System.out.println(result);
        }
    }

    public int find(int target, int[] arr) {
        int low = 0;
        int high = arr.length;

        while (low < high) {

            int mid = (low + high) / 2;

            if (arr[mid] > target) {
                high = mid;
            } else if (arr[mid] < target){
                low = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
