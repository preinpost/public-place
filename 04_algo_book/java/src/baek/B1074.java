package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Z
 */
public class B1074 {

    int n, r, c = 0; // r행 c열
    int counter = 0;
    int br, bc = 0;


    public static void main(String[] args) throws IOException {

        B1074 T = new B1074();

        T.input();

        T.search(T.n);

        System.out.println(T.counter);
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        br = bc = ((Double) Math.pow(2, n)).intValue() / 2;
    }

    public void search(int size) {
        // dfs
        if (size == 1) {
            int pos = findPos(size);
            addValue(pos, size);
            return;
        }

        int pos = findPos(size);
        addValue(pos, size);
        search(size - 1);
    }

    public int findPos(int size) {
        int moveValue = ((Double) Math.pow(2, size - 1)).intValue() / 2;

        if (r < br && c < bc) {
            br -= moveValue;
            bc -= moveValue;
            return 1; // 1사분면
        }
        else if (r < br && c >= bc) {
            br -= moveValue;
            bc += moveValue;
            return 2; // 2사분면
        }
        else if (r >= br && c < bc) {
            br += moveValue;
            bc -= moveValue;
            return 3; // 3사분면
        }
        else if (r >= br && c >= bc) {
            br += moveValue;
            bc += moveValue;
            return 4; // 4사분면
        }

        return -1;
    }

    public void addValue(int pos, int size) {
        int halfValue = (((Double) Math.pow(2, size)).intValue()) / 2;
        int unit = halfValue * halfValue;

        counter += (pos - 1) * unit;
    }
}
