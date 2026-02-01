package lecture.L01;

import java.util.Scanner;

public class L0111 {

    public String solution(String str) {
//        int curPointer = 1;
        char[] charList = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        int counter = 1;

        for (int i = 0; i < charList.length - 1; i++) {
            // index 하나 더 넘어간 부분 처리?
            if (charList[i] == charList[i+1]) {
                counter++;
            } else {
                sb.append(charList[i]);
                if (counter != 1) {
                    sb.append(counter);
                }
                counter = 1;
            }

        }

//        char lastWord = charList[charList.length - 1];
//
//        sb.append(lastWord);
//        sb.append(counter);

        return sb.toString();
    }

    public static void main(String[] args) {
        L0111 T = new L0111();

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(T.solution(str + " "));

    }
}
