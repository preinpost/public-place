package lecture.L02;

import java.util.Scanner;

public class L0206 {

    public void solution(int num) {
        int[] list = new int[num];
        boolean isPrime = true;

        if (num == 1) return;

        for (int i = 2; i < num; i++) {

            if (num % i == 0) {
                isPrime = false;
                break;
            }

        }

        if (isPrime) System.out.print(num + " ");

    }

    public static void main(String[] args) {
        L0206 T = new L0206();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            String num = in.next();
            String sb = new StringBuffer(num).reverse().toString();

            int parseInt = Integer.parseInt(sb);

            T.solution(parseInt);
        }
    }
}
