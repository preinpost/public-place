package basic;

public class DuplicatePermutation {
    // 중복순열
    static int[] dupPermu;

    // 중복순열을 체크배열 사용 (중복확인용)
    static int[] chk;

    public void recursive(int L, int[] arr) {

        if (L == 4) {
            for (int i : dupPermu) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (chk[i] == 1) continue;

            chk[i] = 1;
            dupPermu[L] = arr[i];
            recursive(L+1, arr);
            chk[i] = 0;
        }
    }

    public static void main(String[] args) {
        DuplicatePermutation p = new DuplicatePermutation();

        int[] arr = new int[] {1, 2, 3, 4};
        chk = new int[4];
        dupPermu = new int[4];

        p.recursive(0, arr);
    }

}
