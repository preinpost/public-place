package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }

        for (String s : participant) {
            Integer value = map.get(s);
            if (value == null || value == 0) {
                answer = s;
                break;
            }

            map.put(s, map.get(s)-1);
        }

        return answer;
    }

    public static void main(String[] args) {

        완주하지못한선수 T = new 완주하지못한선수();

        String[] participant, completion;
        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};

        T.solution(participant, completion);

    }
}
