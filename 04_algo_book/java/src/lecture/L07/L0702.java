package lecture.L07;

public class L0702 {

    public void DFS(int n) {
        if (n == 0) return;

        int mod = n % 2;
        DFS(n/2);
        System.out.print(mod + " ");
    }

    public static void main(String[] args) {
        L0702 T = new L0702();
        T.DFS(11);
    }
}
