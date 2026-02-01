package lecture.L06;

import java.util.Scanner;

public class L0604 {

    public void solution(int s, int n, int[] arr) {

        int[] cache = new int[s];

        // 캐시에 값이 없으면, 무조건 끝부분 pop, 하나씩 옮기고, 맨앞에 삽입
        // 캐시에 값이 있으면, 값이 존재하는 인덱스까지 하나씩 옮기고, 맨앞에 삽입

        for (int x : arr) {

            int index = 0;
            for (int i = 0; i < s; i++) {
                if (x == cache[i]) {
                    index = i;
                    break;

                }
            }

            if (index != 0) {
                for (int j = index; j > 0; j--) {
                    cache[j] = cache[j-1];
                }

            } else {
                for (int j = s-1; j > 0; j--) {
                    cache[j] = cache[j-1];
                }
            }
            cache[0] = x;

        }


        for (int i : cache) {
            System.out.print(i + " ");
        }



    }

    public static void main(String[] args) {

        L0604 T = new L0604();

        Scanner in = new Scanner(System.in);

        int s = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        T.solution(s, n, arr);
    }
}
