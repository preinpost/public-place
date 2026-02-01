package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer answer = new StringBuffer();

        int n = Integer.parseInt(bf.readLine());

        // 1. 산술평균
        double tot = 0;

        // 2. 중앙값
        List<Integer> list = new ArrayList<>();

        // 3. 최빈값
        Map<Integer, Integer> map = new HashMap<>();

        // 4. 범위
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;


        for (int i = 0; i < n; i++) {
            int currentNum = Integer.parseInt(bf.readLine());

            tot += currentNum;

            max = Math.max(max, currentNum);
            min = Math.min(min, currentNum);

            list.add(currentNum);

            map.put(currentNum, map.getOrDefault(currentNum, 0) + 1);
        }

        answer.append(Math.round(tot / n)).append("\n");

        Collections.sort(list);
        int median = list.get((n + 1) / 2 - 1);
        answer.append(median).append("\n");

        int freqMax = Integer.MIN_VALUE;


        // 숫자가 나온 횟수 , 숫자들
        Map<Integer, List<Integer>> freqMap = new HashMap<>();


        for (Integer key : map.keySet()) {
            freqMax = Math.max(map.get(key), freqMax);

            List<Integer> countList = freqMap.getOrDefault(map.get(key), new ArrayList<>());
            countList.add(key);
            freqMap.put(map.get(key) ,countList);
        }

        if (freqMap.get(freqMax).size() == 1) {
            answer.append(freqMap.get(freqMax).get(0)).append("\n");
        } else {
            Collections.sort(freqMap.get(freqMax));
            answer.append(freqMap.get(freqMax).get(1)).append("\n");
        }

        answer.append(max - min);

        System.out.println(answer);
    }
}
