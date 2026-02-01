package lecture.L07;

public class L0704 {
    static int[] fibo;

    private int DFS(int n) {
        if (n == 1) return fibo[n] = 1;
        else if (n == 2) return fibo[n] = 1;
        else {
            if (fibo[n] != 0) {
                return fibo[n];
            }

            return fibo[n] = DFS(n-2) + DFS(n-1);
        }
    }

    public static void main(String[] args) {
        L0704 T = new L0704();
        int n = 60;
        fibo = new int[n+1];
        T.DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }

    }

}
