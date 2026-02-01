package lecture.L07;

public class L0701 {

    public void DFS(int n) {
        if (n == 0) return;
        else {
            DFS(n-1);
            System.out.print(n + " ");
        }

    }

    public static void main(String[] args) {

        L0701 T = new L0701();
        T.DFS(3);
    }

}
