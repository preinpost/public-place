package toss2022;

import java.util.*;

public class D_X {

    /**
     * 초대점수 계산법
     * 직접 초대한 사람 수 x 10
     * 내가 초대한 사람이 초대한 사람 수 x 3
     * 내가 초대한 사람이 초대한 사람이 초대한 사람 수 x 1
     *
     * 의 합
     */

    public static void main(String[] args) {
        D_X d = new D_X();

        long[][] invitationPairs = new long[][] { {1,2}, {2,3}, {2,4}, {2,5}, {5,6}, {5,7}, {6,8}, {2,9} };

        d.solution(invitationPairs);
    }

    public long[] solution(long[][] invitationPairs) {
        Map<Long, List<Long>> map = new HashMap<>();
        Map<Long, Long> scoreMap = new HashMap<>();

        for (long[] invitationPair : invitationPairs) {
            List<Long> invitorLinkedList = map.getOrDefault(invitationPair[0], new LinkedList<>());
            invitorLinkedList.add(invitationPair[1]);
            map.put(invitationPair[0], invitorLinkedList);
        }


        for (Long key : map.keySet()) {
            long score = 0L;

            List<Long> list = map.get(key);
            score += list.size() * 10L;

            for (Long id : list) {
                List<Long> id_sub = map.get(id);
                if (id_sub == null) break;

                score += id_sub.size() * 3L;

                for (Long id_sub_sub : id_sub) {
                    List<Long> sub_sub_list = map.get(id_sub_sub);
                    if (sub_sub_list == null) break;

                    score += sub_sub_list.size();
                }
            }

            scoreMap.put(key ,score);
        }




        long[] answer = {};







        return answer;
    }
}
