package leetcode.N1470;

// 1470. Shuffle the Array
public class Solution {
    public int[] shuffle(int[] nums, int n) {
        int length = n * 2;
        int[] answer = new int[length];

        for (int i = 0; i < length; i+=2) {
            answer[i] = nums[i/2];
            answer[i+1] = nums[i/2+n];
        }

        return answer;
    }
}
