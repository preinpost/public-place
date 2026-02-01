package programmers.book.P57;

// P57. [카카오 인턴] 키패드 누르기
class Solution {

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        Pair lastLeftNumber = new Pair(3, 0);
        Pair lastRightNumber = new Pair(3, 2);

        for (int n : numbers) {

            if (n == 1 || n == 4 || n == 7) {
                answer.append("L");
                lastLeftNumber = getKeyPosition(n);
            } else if (n == 3 || n == 6 || n == 9) {
                answer.append("R");
                lastRightNumber = getKeyPosition(n);
            } else {

                Pair numberPos = getKeyPosition(n);

                if (getDistance(numberPos, lastLeftNumber) > getDistance(numberPos, lastRightNumber)) {
                    answer.append("R");
                    lastRightNumber = numberPos;

                } else if (getDistance(numberPos, lastLeftNumber) < getDistance(numberPos, lastRightNumber)) {
                    answer.append("L");
                    lastLeftNumber = numberPos;

                } else {

                    if (hand.equals("right")) {
                        answer.append("R");
                        lastRightNumber = numberPos;
                    } else {
                        answer.append("L");
                        lastLeftNumber = numberPos;
                    }
                }
            }
        }

        return answer.toString();
    }

    private Pair getKeyPosition(int key) {
        switch (key) {
            case 1:
                return new Pair(0, 0);
            case 2:
                return new Pair(0, 1);
            case 3:
                return new Pair(0, 2);
            case 4:
                return new Pair(1, 0);
            case 5:
                return new Pair(1, 1);
            case 6:
                return new Pair(1, 2);
            case 7:
                return new Pair(2, 0);
            case 8:
                return new Pair(2, 1);
            case 9:
                return new Pair(2, 2);
            case 0:
                return new Pair(3, 1);
            default:
                return new Pair(0, 0);
        }
    }

    private int getDistance(Pair a, Pair b) {
        return Math.abs(a.first - b.first) + Math.abs(a.second - b.second);
    }
}