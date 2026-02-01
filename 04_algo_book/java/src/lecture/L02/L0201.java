package lecture.L02;

import java.util.Scanner;

public class L0201 {

    public static void main(String[] args) {
        L0201 T = new L0201();
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        // 여기서 숫자 받을 때, 개수를 알고 있으므로 forloop 개수 nextInt로 받을수도 있다.
        String str = in.nextLine();

        System.out.println(T.solution(n, str));

    }

    private String solution(int n, String str) {
        String[] s = str.split(" ");
        int[] intSet = new int[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            intSet[i] = Integer.parseInt(s[i]);
        }

        sb.append(intSet[0]).append(" ");

        for (int i = 1; i < n; i++) {
            if (intSet[i-1] < intSet[i]) {
                sb.append(intSet[i]).append(" ");
            }
        }

        return sb.toString();
    }
}
