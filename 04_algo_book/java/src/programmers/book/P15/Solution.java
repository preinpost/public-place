package programmers.book.P15;

// P15. 쿼드압축 후 개수 세기
class Solution {

    static class Count {
        int zero;
        int one;

        Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other) {
            return new Count(this.zero + other.zero, this.one + other.one);
        }
    }

    public int[] solution(int[][] arr) {

        Count answer = count(0, 0, arr.length, arr);

        return new int[] {answer.zero, answer.one};
    }


    private Count count(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size / 2;
        for (int i = offsetY; i < offsetY + size; i++) {
            for (int j = offsetX; j < offsetX + size; j++) {
                if (arr[offsetY][offsetX] != arr[i][j]) {
                    return count(offsetX, offsetY, h, arr)
                            .add(count(offsetX + h, offsetY, h, arr))
                            .add(count(offsetX, offsetY + h, h, arr))
                            .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }

        if (arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        } else {
            return new Count(1, 0);
        }
    }
}