package javis2022;

import java.util.Arrays;

public class A {

    /**
     * 점수가 높은 순서대로 학생 번호를 나열
     * index 번호는 1번부터 시작
     */

    public static void main(String[] args) {

        A T = new A();

        String[] students = {"AAALLLAPAA", "AAAAAAAPPP", "ALAAAAPAAA"};
        T.solution(students);
    }

    static class Pair implements Comparable<Pair>{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return o.second - this.second;
        }
    }

    public int[] solution(String[] students) {
        Pair[] answer = new Pair[students.length];

        int idx = 0;
        for (String student : students) {
            int failCnt = 0;
            int lateCnt = 0;
            int score = 10;

            for (int i = 0; i < student.length(); i++) {
                char current = student.charAt(i);

                if (current == 'P') {
                    failCnt++;
                    if (failCnt == 3) {
                        answer[idx] = new Pair(idx, 0);
                        break;
                    }
                    score--;

                } else if (current == 'L') {
                    lateCnt++;
                    if (lateCnt == 2) {
                        lateCnt = 0;
                        failCnt++;

                        if (failCnt == 3) {
                            answer[idx] = new Pair(idx, 0);
                            break;
                        }

                        score--;
                    }
                } else {
                    score++;
                }
            }

            if (failCnt != 3) {
                answer[idx] = new Pair(idx, score);
            }
            idx++;
        }

        Arrays.sort(answer);

        idx = 0;
        int[] answers = new int[students.length];
        for (Pair pair : answer) {
            answers[idx] = pair.first + 1;
            idx++;
        }

        return answers;
    }
}
