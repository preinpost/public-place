package baek;

import java.io.*;
import java.util.ArrayList;

public class B10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> numList = new ArrayList<>();

        String s = bf.readLine();
        int lineNumber = Integer.parseInt(s);

        for (int i = 0; i < lineNumber; i++) {
            s = bf.readLine();
            String[] commandLine = s.split(" ");
            String command = commandLine[0];
            int arg = -1;

            if (commandLine.length > 1) {
                arg = Integer.parseInt(commandLine[1]);
            }

            if ("push".equals(command)) {
                commandPush(numList, arg);
            } else if ("pop".equals(command)) {
                commandPop(numList, sb);
                sb.append("\n");
            } else if ("size".equals(command)) {
                commandSize(numList, sb);
                sb.append("\n");
            } else if ("empty".equals(command)) {
                commandEmpty(numList, sb);
                sb.append("\n");
            } else if ("front".equals(command)) {
                commandFront(numList, sb);
                sb.append("\n");
            } else if ("back".equals(command)) {
                commandBack(numList, sb);
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }



    static void commandPush(ArrayList<Integer> numList, int arg) {
        numList.add(arg);
    }
    static void commandPop(ArrayList<Integer> numList, StringBuilder sb) {
        if (numList.isEmpty()) {
            sb.append(-1);
        } else {
            sb.append(numList.remove(0));
        }
    }
    static void commandSize(ArrayList<Integer> numList, StringBuilder sb) {
        sb.append(numList.size());
    }
    static void commandEmpty(ArrayList<Integer> numList, StringBuilder sb) {
        if (numList.isEmpty()) {
            sb.append(1);
        } else {
            sb.append(0);
        }
    }
    static void commandFront(ArrayList<Integer> numList, StringBuilder sb) {
        if (numList.isEmpty()) {
            sb.append(-1);
        } else {
            sb.append(numList.get(0));
        }
    }
    static void commandBack(ArrayList<Integer> numList, StringBuilder sb) {
        if (numList.isEmpty()) {
            sb.append(-1);
        } else {
            sb.append(numList.get(numList.size() - 1));
        }
    }
}
