package programmers.kakao.blind2022;

import java.util.*;

public class 주차요금계산 {

    public static void main(String[] args) {
        주차요금계산 T = new 주차요금계산();

        int[] fees = new int[] {1, 461, 1, 10};
        String[] records = new String[] {"00:00 1234 IN"};

        int[] solution = T.solution(fees, records);
        for (int i : solution) {
            System.out.print(i + " ");
        }

    }

    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        int maxMinute = 1439;

        Map<String, Queue<Integer>> recordMap = new TreeMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String carNum = split[1];

            String[] timeSplit = time.split(":");
            int hour = Integer.parseInt(timeSplit[0]) * 60;
            int minute = Integer.parseInt(timeSplit[1]);

            if (recordMap.containsKey(carNum)) {
                recordMap.get(carNum).add(hour+minute);
            } else {
                recordMap.put(carNum, new LinkedList<>(List.of(hour + minute)));
            }
        }

        answer = new int[recordMap.size()];

        int idx = 0;
        for (String car : recordMap.keySet()) {
            Queue<Integer> carRec = recordMap.get(car);

            int sum = 0;
            int size = carRec.size();

            if (size % 2 != 0) size--;

            for (int i = 0; i < size/2; i++) {
                Integer in = carRec.poll();
                Integer out = carRec.poll();

                sum += out - in;
            }

            if (!carRec.isEmpty()) {
                Integer in = carRec.poll();
                sum += maxMinute - in;
            }

            if (sum < fees[0]) answer[idx] = fees[1];
            else answer[idx] = fees[1] + (int) Math.ceil((sum - fees[0]) / (double) fees[2]) * fees[3];
            idx++;
        }

        return answer;
    }
}
