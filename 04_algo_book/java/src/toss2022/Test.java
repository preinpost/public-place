package toss2022;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();

        int servers = 2;
        boolean sticky = true;
        int[] requests = new int[]{1,1,2,2};
        int[][] result = test.solution(servers, sticky, requests);

    }

    public int[][] solution(int servers, boolean sticky, int[] requests) {

        int target = 0;

        Map<Integer, List<Integer>> memory = new HashMap<>();
        Map<Integer, Integer> cache = new HashMap<>();

        for (int request : requests) {
            if (sticky) {
                boolean isCacheExist = cache.containsKey(request);

                if (isCacheExist) {
                    Integer serverNumber = cache.get(request);
                    addMemory(serverNumber, memory, request);
                } else {
                    addMemory(target, memory, request);
                    cache.put(request, target);
                    target++;
                }
                
            } else {
                addMemory(target, memory, request);
                target++;
            }

            if (target == servers) target = 0;
        }

        int[][] answer = new int[servers][requests.length];

        for (int i = 0; i < memory.values().size(); i++) {
            answer[i] = memory.get(i).stream().mapToInt(n -> n).toArray();
        }

        return answer;
    }

    public void addMemory(int target, Map<Integer, List<Integer>> memory, int request) {
        List<Integer> serversRequests = memory.getOrDefault(target, new ArrayList<>());
        serversRequests.add(request);

        memory.put(target, serversRequests);
    }
}
