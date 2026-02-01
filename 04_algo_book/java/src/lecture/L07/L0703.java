package lecture.L07;

public class L0703 {

    private int DFS(int n) {
        if (n==1) return 1;
        else return n * DFS(n-1);

    }

    public static void main(String[] args) {
        L0703 T = new L0703();
        System.out.println(T.DFS(5));
    }


}
