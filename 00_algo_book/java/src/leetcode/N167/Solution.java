package leetcode.N167;

// 167. Two Sum II - Input Array Is Sorted
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length - 1;

        while (true) {
            if (numbers[p1] + numbers[p2] < target) {
                // 여기서는 p1을 올려야함
                p1 += 1;

            } else if (numbers[p1] + numbers[p2] > target) {
                // 여기서는 p2을 내려야함
                p2 -= 1;
            } else {
                // target과 같을 때
                return new int[] {p1 + 1, p2 + 1};
            }
        }
    }
}