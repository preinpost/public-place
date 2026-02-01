package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2920 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        String[] strArray = s.split(" ");

        int p1 = 0;
        int p2 = 1;

        int status = -1; // 0: ascending 1: descending 2: mixed

        if (Integer.parseInt(strArray[p2]) > Integer.parseInt(strArray[p1])) status = 0;
        else status = 1;

        p1++;
        p2++;

        while (p2 < strArray.length) {
            if (status == 0 && (Integer.parseInt(strArray[p2]) > Integer.parseInt(strArray[p1]))) {
                status = 0;
            } else if (status == 1 && (Integer.parseInt(strArray[p2]) < Integer.parseInt(strArray[p1]))) {
                status = 1;
            } else {
                status = 2;
                break;
            }
            p1++;
            p2++;

        }

        switch (status) {
            case 0:
                System.out.println("ascending");
                break;
            case 1:
                System.out.println("descending");
                break;
            case 2:
                System.out.println("mixed");
                break;
        }
    }
}
