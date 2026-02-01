package devtest2021;

public class One {

    static class Solution {
        public int solution(String[] drum) {

            // N과 M 길이 정의
            Integer N = drum.length;
            Integer M = drum[0].length();

            int answer = 0;
            int start = 0;


            // ######
            // >#*###
            // ####*#
            // #<#>>#
            // >#*#*<
            // ######

            while (start < N) {
                Integer pointer_x = start, pointer_y = 0;
                int isEnd = 0;

                while (pointer_y < M) {
                    char currentChar = drum[pointer_y].charAt(pointer_x);

                    if (currentChar == '#') {
                        pointer_y++;

                    } else if (currentChar == '>') {
                        pointer_x++;

                    } else if (currentChar == '<') {
                        pointer_x--;

                    } else {
                        // * 일 때,
                        isEnd++;
                        if (isEnd <= 2) {
                            pointer_y++;
                        }
                    }

                    boolean isCountinue = validatePointer(N, M, pointer_x, pointer_y, isEnd);
                    if (!isCountinue) break;

                    if (pointer_y >= M) {
                        answer++;
                    }
                }
                start++;
            }

            return answer;
        }
    }

    public static boolean validatePointer(Integer N, Integer M, Integer pointer_x, Integer pointer_y, int isEnd) {
        if (isEnd == 2) return false;

        if (pointer_x > N || pointer_x < 0) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) {

        String[] drum = {"######",">#*###","####*#","#<#>>#",">#*#*<","######"};

        Solution sol = new Solution();
        int solution = sol.solution(drum);


    }

}
