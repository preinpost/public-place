package leetcode.N1929;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int[] answer = new int[nums.length*2];

        for (int i = 0; i < nums.length*2; i++) {
            answer[i] = nums[i%nums.length];
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
