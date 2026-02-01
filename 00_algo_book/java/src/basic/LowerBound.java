package basic;

public class LowerBound {

    static public int find(int[] arr, int key) {
        int p1 = 0;
        int p2 = arr.length;

        while (p1 < p2) {

            int mid = (p1 + p2) / 2;

            if (key <= arr[mid]) {
                p2 = mid;
            } else {
                p1 = mid + 1;
            }
        }

        return p1;
    }
}
