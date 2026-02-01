package programmers.book.P19;

// P19. 카펫
class Solution {
    public int[] solution(int brown, int yellow) {
        int limit = (brown) / 2;

        for (int i = 3; i <= limit; i++) {
            int widthCnt = i * 2;

            for (int j = 3; j <= i; j++) {
                int heightCnt = (j - 2) * 2;

                if (widthCnt + heightCnt == brown && i * j - brown == yellow) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}
