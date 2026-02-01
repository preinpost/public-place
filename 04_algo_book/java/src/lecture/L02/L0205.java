package lecture.L02;

import java.util.Scanner;

public class L0205 {

    public void solution(int n) {
        int answer = 0;

        int[] ch = new int[n+1];
        for (int i = 2; i < n; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j = i; j <= n; j=j+i) {
                    ch[j] = 1;
                }
            }
        }


        System.out.print(answer);
    }

    public static void main(String[] args) {
        L0205 T = new L0205();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        T.solution(n);
    }
}
