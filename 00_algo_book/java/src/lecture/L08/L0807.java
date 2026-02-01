package lecture.L08;

import java.util.*;

public class L0807 {

    Map<String, Integer> chkMap = new HashMap<>();

    public void solution(int n, int r) {

        int answer = recursive(n, r);
        System.out.println(answer);
    }

    public int recursive(int n, int r) {

        if (r == 1 || n-r == 1) {
            return n;
        }

        int f1;
        int f2;

        if (chkMap.containsKey((n-1)+","+(r-1))) {
            f1 = chkMap.get((n-1)+","+(r-1));
        } else {
            f1 = recursive(n-1, r-1);
            chkMap.put((n-1)+","+(r-1), f1);
        }

        if (chkMap.containsKey((n-1)+","+(r))) {
            f2 = chkMap.get((n-1)+","+(r));
        } else {
            f2 = recursive(n-1, r);
            chkMap.put((n-1)+","+(r), f2);
        }

        return f1 + f2;
    }

    public static void main(String[] args) {

        L0807 T = new L0807();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int r = in.nextInt();

        T.solution(n, r);
    }
}
