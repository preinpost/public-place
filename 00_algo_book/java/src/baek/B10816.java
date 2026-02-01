package baek;

import basic.LowerBound;
import basic.UpperBound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class B10816 {

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(bf.readLine());
        int[] arr = new int[m];

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);


        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArr = IntStream.of(arr).sorted().toArray();

        Map<Integer, Integer> map = new HashMap<>();

        int p1 = 0, p2 = 0, cnt = 0;

        while (p1 <= p2) {

            if (p2 >= m) {
                map.put(sortedArr[p1], cnt);
                break;
            }

            // 다른 경우
            if (sortedArr[p1] != sortedArr[p2]) {

                map.put(sortedArr[p1], cnt);
                p1 = p2;
                cnt = 0;
                continue;
            }
            // 같은 경우
            cnt++;
            p2++;
        }

        int k = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < k; i++) {
            sb.append(map.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(" ");
        }

        System.out.println(sb);
    }
}
