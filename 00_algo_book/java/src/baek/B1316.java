package baek;

import java.util.Scanner;

public class B1316 {

    static int answer;

    public void solution(String s) {
        int[] alphabet = new int[26];

        int p1 = 0;
        int p2 = 1;

        char[] chars = s.toCharArray();

        if (chars.length == 1) return;

        while (p2 < chars.length) {

            if (chars[p1] != chars[p2]) {
                int cn = chars[p1] - 97;

                if (alphabet[cn] == 1) {
                    answer--;
                    return;
                }
                alphabet[cn] = 1;
            }
            p1++;
            p2++;
        }

        int cn = chars[p2-1] - 97;
        if (alphabet[cn] == 1) {
            answer--;
        }
    }

    public static void main(String[] args) {

        B1316 b1316 = new B1316();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        answer = n;

//        char a = 'a'; // 97 - 97 = 0
//        char z = 'z'; // 122 - 97 = 25

        for (int i = 0; i < n; i++) {
            b1316.solution(in.nextLine());
        }
        System.out.println(answer);
    }
}
