package baek;

import java.io.*;

public class B10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bf.readLine();
        int lineNumber = Integer.parseInt(s);

        s = bf.readLine();
        String[] line = s.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < lineNumber; i++) {
            min = Math.min(min, Integer.parseInt(line[i]));
            max = Math.max(max, Integer.parseInt(line[i]));
        }

        bw.write(String.format("%d %d", min, max));
        bw.flush();
        bw.close();
    }
}
