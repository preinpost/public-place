package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11399 {

    public void solution(int n, int[] arr) {
        int[] sortedArr = Arrays.stream(arr).sorted().toArray();
        int[] dp = new int[n];

        int answer = sortedArr[0];
        dp[0] = sortedArr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + sortedArr[i];
            answer += dp[i];
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {

        B11399 T = new B11399();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        T.solution(n, arr);
    }

}
