package programmers.book.P20;

import java.util.*;

// P20. 수식 최대화
class Solution {

    private String[][] order = {
            "*+-".split(""),
            "*-+".split(""),
            "+*-".split(""),
            "+-*".split(""),
            "-*+".split(""),
            "-+*".split(""),
    };


    public long solution(String expression) {

        StringTokenizer st = new StringTokenizer(expression, "-+*", true);
        ArrayList<String> exp = new ArrayList<>();

        while (st.hasMoreTokens()) {
            exp.add(st.nextToken());
        }

        long answer = Long.MIN_VALUE;

        for (String[] signArr : order) {
            ArrayList<String> copyList = (ArrayList<String>) exp.clone();

            for (String sign : signArr) {
                for (int i = 0; i < copyList.size(); i++) {

                    if (copyList.get(i).equals(sign)) {
                        String result = calculate(copyList.get(i-1), copyList.get(i+1), sign);
                        copyList.remove(i-1);
                        copyList.remove(i-1);
                        copyList.remove(i-1);
                        copyList.add(i-1, result);
                        i -= 2;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(copyList.get(0))));
        }
        return answer;
    }

    private String calculate(String lhs, String rhs, String sign) {
        switch (sign) {
            case "*":
                return String.valueOf(Long.parseLong(lhs) * Long.parseLong(rhs));
            case "+":
                return String.valueOf(Long.parseLong(lhs) + Long.parseLong(rhs));
            case "-":
                return String.valueOf(Long.parseLong(lhs) - Long.parseLong(rhs));
        }

        return "";
    }
}