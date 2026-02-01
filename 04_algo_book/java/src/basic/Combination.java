package basic;

public class Combination {
   // 조합
    static int[] combi;

    public void recursive(int L, int s, int[] arr) {

        if (L == 3) {
            for (int i : combi) {
                System.out.print(i + " ");
            }
            System.out.println();

            return;
        }

        for (int i = s; i < arr.length; i++) {
            combi[L] = arr[i];
            recursive(L+1, i+1, arr);
        }
    }

    public static void main(String[] args) {
        Combination c = new Combination();

        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        combi = new int[3];

        c.recursive(0, 0, arr);
    }
}
