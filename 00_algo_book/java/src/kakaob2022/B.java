package kakaob2022;

import java.util.Arrays;

public class B {

    public int[] solution(int[] black_caps) {
        Integer[] candid = new Integer[black_caps.length];

        // 1. 맨 앞뒤 먼저 확인
        searchFirstAndEnd(black_caps, candid);

        // 2. 2탐색
        searchTwo(black_caps, candid);

        // 3. 0탐색
        searchZero(black_caps, candid);

        // 6. 알수없는 사람 추가
        addUnKnown(candid);

        // 4. 2가 근처에 있는 1 탐색
        searchTwoBasedOneFind(black_caps, candid);

        // 5. 1이 근처에 있는 1 탐색
        searchZeroBasedOneFind(black_caps, candid);



        System.out.println();

        return Arrays.stream(candid).mapToInt(Integer::intValue).toArray();
    }

    private void searchZeroBasedOneFind(int[] black_caps, Integer[] candid) {
        for (int i = 1; i < black_caps.length-1; i++) {

            if (black_caps[i] == 1 && candid[i+1] == 1) {
                candid[i-1] = 2;
            }

            if (black_caps[i] == 1 && candid[i-1] == 1) {
                candid[i+1] = 2;
            }
        }
    }

    private void searchZero(int[] black_caps, Integer[] candid) {
        for (int i = 1; i < black_caps.length-1; i++) {
            if (black_caps[i] == 0) {
                candid[i-1] = 2;
                candid[i+1] = 2;
            }
        }
    }

    private void addUnKnown(Integer[] candid) {
        for (int i = 0; i < candid.length; i++) {
            if (candid[i] == null) candid[i] = 0;
        }
    }

    private void searchTwoBasedOneFind(int[] black_caps, Integer[] candid) {
        for (int i = 1; i < black_caps.length-1; i++) {

            if (black_caps[i] == 1 && candid[i+1] == 2) {
                candid[i-1] = 1;
            }

            if (black_caps[i] == 1 && candid[i-1] == 2) {
                candid[i+1] = 1;
            }
        }
    }

    public void searchTwo(int[] black_caps, Integer[] candid) {
        for (int i = 1; i < black_caps.length-1; i++) {
            if (black_caps[i] == 2) {
                candid[i-1] = 1;
                candid[i+1] = 1;
            }
        }
    }

    public void searchFirstAndEnd(int[] black_caps, Integer[] candid) {
        if (black_caps[0] == 1) candid[1] = 1;
        else candid[1] = 2;

        if (black_caps[black_caps.length-1] == 1) candid[black_caps.length-2] = 1;
        else candid[black_caps.length-2] = 2;
    }

    public static void main(String[] args) {
        B b = new B();

//        int[] black_caps = new int[] {0, 0, 0};
//        int[] black_caps = new int[] {1, 2, 2, 2, 1};
//        int[] black_caps = new int[] {1, 1, 1, 1, 1};
//        int[] black_caps = new int[] {1, 2, 1};
//        int[] black_caps = new int[] {1, 0, 1};
//        int[] black_caps = new int[] {1, 1, 2, 0};
        int[] black_caps = new int[] {1, 1, 1};

        b.solution(black_caps);
    }

}
