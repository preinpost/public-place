package basic;

public class DuplicateCombination {
    // 중복조합
    static int[] dupCombi;

    public void recursive(int L, int s, int[] arr) {

        if (L == 4) {
            for (int i : dupCombi) {
                System.out.print(i + " ");
            }
            System.out.println();

            return;
        }

        for (int i = s; i < arr.length; i++) {
            dupCombi[L] = arr[i];
            // 다음 재귀 시작값을 현재 선택한 값으로 지정
            recursive(L+1, i, arr);
        }
    }

    public static void main(String[] args) {
        DuplicateCombination c = new DuplicateCombination();

        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        dupCombi = new int[4];

        c.recursive(0, 0, arr);
    }
}
