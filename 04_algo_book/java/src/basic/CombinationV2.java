package basic;

public class CombinationV2 {

    int[] candid;

    public static void main(String[] args) {

        CombinationV2 T = new CombinationV2();

        int[] arr = new int[] {1, 2, 3, 4, 5};
        T.candid = new int[3];

        T.combination(0, 0, arr);


    }

    public void combination(int depth, int s, int[] arr) {
        if (depth == 3) {
            for (int i : candid) {
                System.out.print(i +  " ");
            }
            System.out.println();

            return;
        }

        for (int i = s; i < arr.length; i++) {
            candid[depth] = arr[i];
            combination(depth + 1, i + 1, arr);
        }
    }
}
