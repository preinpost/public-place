package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 라면 사기 (Small)
public class B18185 {

    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/board/view/83786 반례 참고

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        String s = bf.readLine();
        int[] factoryArr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        int cost = 0;

        for (int i = 0; i < n; i++) {
            if (factoryArr[i] == 0) {
                continue;
            }

            if (i < n - 2 && factoryArr[i + 1] > factoryArr[i + 2]) {
                factoryArr[i] -= 1;
                factoryArr[i + 1] -= 1;
                cost += 5;
                i -= 1;
                continue;
            }

            if (i < n - 2 && factoryArr[i] != 0 && factoryArr[i + 1] != 0 && factoryArr[i + 2] != 0) {
                factoryArr[i] -= 1;
                factoryArr[i + 1] -= 1;
                factoryArr[i + 2] -= 1;
                cost += 7;
                i -= 1;
            } else if (i < n - 1 && factoryArr[i] != 0 && factoryArr[i + 1] != 0) {
                factoryArr[i] -= 1;
                factoryArr[i + 1] -= 1;
                cost += 5;
                i -= 1;
            } else {
                cost += factoryArr[i] * 3;
                factoryArr[i] = 0;
            }
        }
        System.out.println(cost);
    }
}
