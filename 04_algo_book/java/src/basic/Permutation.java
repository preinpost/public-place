package basic;

public class Permutation {
    // 순열
    static int[] permu;

    public void recursive(int L, int[] arr) {

        if (L == 2) {
            for (int i : permu) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            permu[L] = arr[i];
            recursive(L+1, arr);
        }
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();

        int[] arr = new int[] {1, 2, 3, 4};
        permu = new int[2];

        p.recursive(0, arr);
    }
}
