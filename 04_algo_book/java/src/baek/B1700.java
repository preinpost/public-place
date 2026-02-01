package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class B1700 {

    // 멀티탭 구멍의 개수 N
    // 전기 용품의 총 사용횟수 K
    // 하나씩 플러그를 빼는 최소의 횟수를 출력하시오.
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int k = Integer.parseInt(s.split(" ")[1]);
        int answer = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        s = bf.readLine();

        List<Integer> numberList = Arrays.stream(s.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Set<Integer> use = new HashSet<>();

        {
            for (Integer i : numberList) {
                countMap.put(i, countMap.getOrDefault(i, 0) + 1);
            }
        }

        for (int i = 0; i < numberList.size(); i++) {
            int current = numberList.get(i);

            // 멀티탭이 다 차지 않았다면, 그냥 꽂아준다.
            if (use.size() < n) {
                use.add(current);
                count(countMap, current);
                continue;
            }

            // 멀티탭에 이미 꽂혀있는 경우에는 전체 개수만 빼준다.
            if (use.contains(current)) {
                count(countMap, current);
                continue;
            }

            // 콘센트 뺄거 결정
            // 1. 이후에 쓰는 않는 콘센트
            boolean flag = false;
            for (Integer u : use) {
                if (!countMap.containsKey(u)) {
                    use.remove(u);
                    use.add(current);
                    count(countMap, current);
                    flag = true;
                    break;
                }
            }

            if (flag) {
                answer += 1;
                continue;
            }

            Set<Integer> copySet = new HashSet<>(use);

            // 2. 모두 이후에 사용한다면 가장 사용중인 콘센트 중에서 마지막에 사용하는 콘센트
            for (int j = i + 1; j < numberList.size(); j++) {
                // 콘센트가 하나인 경우는 무조건 교체
                if (n == 1) break;

                if (copySet.contains(numberList.get(j))) {
                    copySet.remove(numberList.get(j));

                    if (copySet.size() == 1) {
                        break;
                    }
                }
            }

            use.remove(copySet.iterator().next());
            use.add(current);
            count(countMap, current);
            answer += 1;
        }

        System.out.println(answer);
    }

    static void count(Map<Integer, Integer> map, int number) {
        Integer i = map.get(number);

        if (i - 1 == 0) {
            map.remove(number);
        } else {
            map.put(number, i - 1);
        }
    }
}
