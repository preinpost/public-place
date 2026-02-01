package leetcode.N2391;

// 2391. Minimum Amount of Time to Collect Garbage
class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {

        char[] candidChar = new char[] {'P', 'G', 'M'};
        int[] travelValue = new int[3];
        int answer = 0;
        int currentValue = 0;

        for (int i = 0; i < garbage.length; i++) {
            String s = garbage[i];

            if (i != 0) {
                currentValue += travel[i - 1];

                if (s.contains("P")) {
                    travelValue[0] = currentValue;
                }

                if (s.contains("G")) {
                    travelValue[1] = currentValue;
                }

                if (s.contains("M")) {
                    travelValue[2] = currentValue;
                }
            }

            for (char c : s.toCharArray()) {
                if (c == 'P' || c == 'G' || c == 'M') {
                    answer += 1;
                }
            }
        }

        for (int v : travelValue) {
            answer += v;
        }

        return answer;
    }
}