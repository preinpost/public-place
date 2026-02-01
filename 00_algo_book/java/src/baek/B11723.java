package baek;

import java.io.*;

public class B11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] group = new int[21];

        String s = bf.readLine();
        int commandCnt = Integer.parseInt(s);

        for (int i = 0; i < commandCnt; i++) {
            s = bf.readLine();
            String[] line = s.split(" ");

            String command = line[0];
            int number = -1;

            if (line.length == 2) {
                number = Integer.parseInt(line[1]);
            }

            if ("add".equals(command)) {
                commandAdd(group, number);
            } else if ("remove".equals(command)) {
                commandRemove(group, number);
            } else if ("check".equals(command)) {
                commandCheck(group, number, bw);
            } else if ("toggle".equals(command)) {
                commandToggle(group, number);
            } else if ("all".equals(command)) {
                commandAll(group);
            } else if ("empty".equals(command)) {
                commandEmpty(group);
            }
        }

        bw.flush();
        bw.close();
        bf.close();
    }

    public static void commandAdd(int[] group, int number) {
        group[number] = 1;
    }

    public static void commandRemove(int[] group, int number) {
        group[number] = 0;
    }

    public static void commandCheck(int[] group, int number, BufferedWriter bw) throws IOException {
        bw.write((group[number] == 1 ? "1" : "0") + "\n");
    }

    public static void commandToggle(int[] group, int number) {
        if (group[number] == 1) {
            group[number] = 0;
        } else {
            group[number] = 1;
        }
    }

    public static void commandAll(int[] group) {
        for (int i = 1; i <= 20; i++) {
            group[i] = 1;
        }
    }
    public static void commandEmpty(int[] group) {
        for (int i = 1; i <= 20; i++) {
            group[i] = 0;
        }
    }
}
