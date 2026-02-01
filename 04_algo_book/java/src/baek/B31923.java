package baek;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 마라탕후루
public class B31923 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        String[] split = s.split(" ");
        int n = Integer.parseInt(split[0]);
        int p = Integer.parseInt(split[1]);
        int q = Integer.parseInt(split[2]);

        s = bf.readLine();
        String[] pArr = s.split(" ");

        s = bf.readLine();
        String[] qArr = s.split(" ");

        StringBuffer sb = new StringBuffer();


        for (int i = 0; i < n; i++) {

            if (q - p == 0) {
                if (Integer.parseInt(pArr[i]) - Integer.parseInt(qArr[i]) != 0) {
                    System.out.println("NO");
                    return;
                } else {
                    sb.append(0).append(" ");
                }
            } else {

                if ((Integer.parseInt(pArr[i]) - Integer.parseInt(qArr[i])) % (q - p) == 0) {
                    int r = (Integer.parseInt(pArr[i]) - Integer.parseInt(qArr[i])) / (q - p);
                    if (0 <= r && r <= 10000) {
                        sb.append(Double.valueOf(r).intValue()).append(" ");
                    } else {
                        System.out.println("NO");
                        return;
                    }
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
        System.out.println(sb);
    }
}
