package programmers.kakao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 추석트래픽 {

    public static void main(String[] args) {
        추석트래픽 c = new 추석트래픽();

        String[] lines = new String[] {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };

        int solution = c.solution(lines);
        System.out.println(solution);
    }

    public int solution(String[] lines) {
        int answer = 0;

        int[] startTimes = new int[lines.length];
        int[] endTimes = new int[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String currentLine = lines[i];
            String[] split = currentLine.split(" ");
            String time = split[1];
            int endTime = getMilsTime(time);
            int lapseTime = (int)(Double.parseDouble(split[2].split("s")[0]) * 1000);
            int startTime = endTime - lapseTime + 1;

            startTimes[i] = startTime;
            endTimes[i] = endTime;
        }


        // window 만들기

        // 1. 시작점 ~ 시작점+1 윈도우
        // 2. 종료점 ~ 종료점+1 윈도우


        // 1번
        for (int i = 0; i < lines.length; i++) {
            int window_start = startTimes[i];
            int window_end = window_start + 1000;
            int cnt = 0;

            for (int j = 0; j < lines.length; j++) {
                if (window_start <= endTimes[j] && window_end > endTimes[j]) cnt++;
                else if (window_start <= startTimes[j] && window_end > startTimes[j]) cnt++;
                else if (window_start >= startTimes[j] && window_end <= endTimes[j]) cnt++;
            }
            answer = Math.max(answer, cnt);
        }

        // 2번
        for (int i = 0; i < lines.length; i++) {
            int window_start = endTimes[i];
            int window_end = window_start + 1000;
            int cnt = 0;

            for (int j = 0; j < lines.length; j++) {
                if (window_start <= endTimes[j] && window_end > endTimes[j]) cnt++;
                else if (window_start <= startTimes[j] && window_end > startTimes[j]) cnt++;
                else if (window_start >= startTimes[j] && window_end <= endTimes[j]) cnt++;
            }
            answer = Math.max(answer, cnt);
        }

//        for (int i = 0; i < lines.length; i++) {
//            int endWindow = endTimes[i] + 1000;
//            int count = 1;
//
//            for (int j = i + 1; j < lines.length; j++) {
//                int startTime = startTimes[j];
//                if (endWindow > startTime) {
//                    count++;
//                }
//            }
//            answer = Math.max(answer, count);
//        }


        return answer;
    }

    private int getMilsTime(String time) {
        String[] timeSplit = time.split(":");
        int hour = Integer.parseInt(timeSplit[0]) * 60 * 60 * 1000;
        int minute = Integer.parseInt(timeSplit[1]) * 60 * 1000;
        int second = (int) (Double.parseDouble(timeSplit[2])) * 1000;
        int mills = Integer.parseInt(timeSplit[2].split("\\.")[1]);

        return hour + minute + second + mills;
    }
}
