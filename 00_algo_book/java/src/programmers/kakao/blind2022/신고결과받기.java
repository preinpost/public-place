package programmers.kakao.blind2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 신고결과받기 {
    public static void main(String[] args) {
        신고결과받기 T = new 신고결과받기();

        String[] id_list, report;
        int k=2;

        id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        int[] solution = T.solution(id_list, report, k);

        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, List<String>> reportMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        // 기본 id 세팅
        for (String id : id_list) {
            reportMap.put(id, new ArrayList<String>());
            countMap.put(id, 0);
        }

        // id - 신고자 map
        for (String rep : report) {
            String[] split = rep.split(" ");
            String reporter = split[0];
            String target = split[1];


            List<String> list = reportMap.get(target);
            boolean isContain = list.contains(reporter);
            if (isContain == false) {
                list.add(reporter);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            if (reportMap.get(id).size() >= k) {
                for (String repo_id : reportMap.get(id)) {
                    countMap.put(repo_id, countMap.get(repo_id)+1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = countMap.get(id_list[i]);
        }

        return answer;
    }
}
