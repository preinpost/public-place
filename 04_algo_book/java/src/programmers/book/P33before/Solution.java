package programmers.book.P33before;

// P33. 바뀌기전 - 평행
class Solution {
    public int solution(int[][] dots) {
        if (getInc(dots[0][0], dots[1][0], dots[0][1], dots[1][1]) == getInc(dots[2][0], dots[3][0], dots[2][1], dots[3][1])) return 1;
        if (getInc(dots[0][0], dots[2][0], dots[0][1], dots[2][1]) == getInc(dots[1][0], dots[3][0], dots[1][1], dots[3][1])) return 1;
        if (getInc(dots[0][0], dots[3][0], dots[0][1], dots[3][1]) == getInc(dots[1][0], dots[2][0], dots[1][1], dots[2][1])) return 1;

        return 0;
    }

    private double getInc(int x1, int x2, int y1, int y2) {
        return (double) (y2- y1) / (x2 - x1);
    }
}