package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1002 {

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(stn.nextToken());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(find(x1, y1, r1, x2, y2, r2));
            if (i != n-1)
                sb.append("\n");
        }

        System.out.println(sb);
    }

    public double calculateTwoPointDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public int find(int x1, int y1, int r1, int x2, int y2, int r2) {
        double d = calculateTwoPointDistance(x1, y1, x2, y2);

        if (x1 == x2 && y1 == y2 && r1 == r2) return -1;

        if (d > r1 + r2 || d < Math.max(r1, r2) - Math.min(r1, r2)) return 0;
        else if (Math.max(r1, r2) - Math.min(r1, r2) < d && r2 + r1 > d) return 2;
        else return 1;
    }

    public static void main(String[] args) throws IOException {
        B1002 b1002 = new B1002();

        b1002.input();
    }
}
