package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10816V2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();

        int n = Integer.parseInt(line);
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i += 1;
        }

        int m = Integer.parseInt(bf.readLine());
        int[] searchArr = new int[m];
        st = new StringTokenizer(bf.readLine());

        i = 0;
        while (st.hasMoreTokens()) {
            searchArr[i] = Integer.parseInt(st.nextToken());
            i += 1;
        }

        Arrays.sort(arr);

        StringBuilder builder = new StringBuilder();

        for (int num : searchArr) {
            int upper = upperBound(num, arr);
            int lower = lowerBound(num, arr);

            builder.append(upper - lower).append(" ");
        }

        System.out.println(builder);
    }

    static private int upperBound(int findNum, int[] arr) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] <= findNum) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }

    static private int lowerBound(int findNum, int[] arr) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] >= findNum) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
