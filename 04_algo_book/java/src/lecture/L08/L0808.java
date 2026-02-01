package lecture.L08;

import java.util.ArrayList;
import java.util.Scanner;

public class L0808 {

    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean flag = false;

    public void solution(int n, int f) {
        DFS(0, n, f);
    }

    public void DFS(int level, int n, int f) {
        if (flag) return;

        if (level == n) {
            boolean result = simulation(arr, n, f);
            if (result) {
                for (Integer integer : arr) {
                    System.out.print(integer + " ");
                }
                System.out.println();
                flag = true;
                return;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!arr.contains(i)){
                arr.add(i);
                DFS(level+1, n, f);
                arr.remove(arr.size()-1);
            }
        }
    }

    public boolean simulation(ArrayList<Integer> possibleList, int n, int f) {
        int[] pArr = new int[n-1];
        boolean isFirst = true;

        while (n>1) {
            for (int i = 0; i < n-1; i++) {
                if (isFirst) {
                    pArr[i] = possibleList.get(i) + possibleList.get(i + 1);
                } else {
                    pArr[i] = pArr[i] + pArr[i+1];
                }
            }
            n--;
            isFirst = false;
        }

        return pArr[0] == f;
    }

    public static void main(String[] args) {

        L0808 T = new L0808();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int f = in.nextInt();

        T.solution(n, f);
    }
}
