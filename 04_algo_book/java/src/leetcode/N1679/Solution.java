package leetcode.N1679;

import java.util.Arrays;

public class Solution {

    /*
        nums = [1,2,3,4], k = 5
        nums = [3,1,3,4,3], k = 6

        1 3 3 3 4

        1. k보다 큰 수는 먼저 제거한다.
        3 7 9 2 4 5 k = 6

        2 3 4 5
        2. 투포인터 p1, p2
            맨앞과 맨 끝을 더해서 k보다 크면 p2를 -- 해준다.
            p1 <= p2 까지 반복
                a. 그때까지 없으면 p1++
                b. 중간에 만났을 경우 p1++ p2--

        2 3 4 5 7 9

        조합으로?
        => 2개를 뽑아야함. => 뽑은 값이 k랑 같아야한다.

     */

    public int maxOperations(int[] nums, int k) {

        int[] ints = Arrays.stream(nums).filter(x -> x < k).sorted().toArray();

        int answer = 0;
        int p1 = 0;
        int p2 = ints.length-1;

        while (p1 < p2) {

            if (ints[p1] + ints[p2] > k) {
                p2--;
            } else if (ints[p1] + ints[p2] < k) {
                p1++;
            } else {
                answer++;
                p1++;
                p2--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

//        int[] nums = {3, 1, 3, 4, 3};
        int[] nums = {1,2,3,4};

        int result = sol.maxOperations(nums, 5);
        System.out.println(result);
    }


}
