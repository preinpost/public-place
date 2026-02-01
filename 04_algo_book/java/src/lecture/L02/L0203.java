package lecture.L02;

import java.util.Scanner;

public class L0203 {

    public static void main(String[] args) {
        L0203 T = new L0203();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] aList = new int[n];
        int[] bList = new int[n];
        in.nextLine();

        for (int i =0 ; i < n; i++) {
            aList[i] = in.nextInt();
        }

        in.nextLine();

        for (int i =0 ; i < n; i++) {
            bList[i] = in.nextInt();
        }

        T.solution(n, aList, bList);

    }

    private void solution(int n, int[] aList, int[] bList) {

        // 1 : 가위 , 2: 바위 , 3: 보

        // 가위가 이기는 경우(1)
        // 3

        // 바위가 이기는 경우(2)
        // 1

        // 보가 이기는 경우(3)
        // 2


        for (int i = 0; i < n; i++) {

            int aPlay = aList[i];
            int bPlay = bList[i];

            if (aPlay == bPlay) {
                System.out.println("D");
                continue;
            }


            switch (aPlay) {
                case(1):
                    if (bPlay == 3) System.out.println("A");
                    else System.out.println("B");
                    break;
                case(2):
                    if (bPlay == 1) System.out.println("A");
                    else System.out.println("B");
                    break;
                case(3):
                    if (bPlay == 2) System.out.println("A");
                    else System.out.println("B");
                    break;
                default:
                    break;
            }
        }
    }
}
