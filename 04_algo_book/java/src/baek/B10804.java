package baek;

import java.util.Scanner;

public class B10804 {

    static int[] deck = new int[21];

    public void swapDeck(int start, int end) {

        int len = end - start + 1;

        for (int i = 0; i < len/2; i++) {
            int tmp = deck[end - i];
            deck[end - i] = deck[start + i];
            deck[start + i] = tmp;
        }
    }

    public static void main(String[] args) {

        B10804 T = new B10804();

        for (int i = 1; i <= 20; i++) {
            deck[i] = i;
        }

        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int s = in.nextInt();
            int e = in.nextInt();

            T.swapDeck(s, e);
        }

        for (int i = 1 ; i <= 20; i++) {
            System.out.print(deck[i] + " ");
        }
    }
}
