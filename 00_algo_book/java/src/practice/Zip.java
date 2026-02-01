package practice;

import java.util.ArrayList;
import java.util.List;

public class Zip {
    public static void main(String[] args) {
        // aabbaccc -> 2a2ba3c
        // ababcdcd ababcdcd -> 2ababcdcd
        // abc abc de de -> 2abcdede


        String s = "ababcdcdababcdcd";
        System.out.println("s = " + s.length());


        // 1단위, 2단위, 3단위, 4단위, 5단위, 6단위, 7단위, 8단위, 9단위(X)
        // 최대길이 / (해당 단위길이) == 1이 되는 시점이 마지막 지점
        System.out.println("16/9 = " + 16 / 9);


        // 자른 문자열들 저장해서, 배열에 담고, 같은 배열이 있는지 확인해야함.

        System.out.println("s.indexOf(0, 2) = " + s.substring(0, 2));

        // ab ab cd cd ab ab cd cd
        // aba bcd cda bab cdc d 0-3 3-6 6-9 9-12 12-15 15-16

        System.out.println("s.substring(15, 16) = " + s.substring(15, 16));

        int length = s.length();
        int currBlock = 1;

        String[] saveBlock = new String[length];
        List<String> testList = new ArrayList<>();

        while (true) {
            System.out.println("currBlock = " + currBlock);
            if (length / currBlock == 1) break;

            // 숫자열 생성필요
            int adjustValue = 0;
            int lastJ = 0;
            s = "ababcdcdababcdcd";
            String result = null;

            for (int i = 0; i < length ; i=i+currBlock) {
//                System.out.println("i = " + i);

                for (int j = 0; j < i + currBlock; ) {

                    if (j > length - 1 ) {
                        // 종료 조건

                        break;
                    }

                    lastJ = j;

                    j++;
                }



                if (lastJ + currBlock < length) {
                    System.out.println("i= " + i);
                    System.out.println("lastJ = " + lastJ);
                    result = s.substring(lastJ, lastJ + currBlock);

                } else {
                    System.out.println("i= " + i);
                    result = s.substring(lastJ, length);
                }

                System.out.println("result = " + result);
                testList.add(result);

//                System.out.println("lastJ to lastJ + currB = " + lastJ + " to " + (lastJ + currBlock));

//                System.out.println("=========================");
            }

            System.out.println("testList = " + testList);


            testList = new ArrayList<>();



            currBlock++;
        }





        // 나눌 수 있는 블록 지정해주기
        // 해당 갯수로 쪼갠 문자열의 길이 저장하기
        // 최대로 나눌 수 있는 방법이 없다면, 저장한 문자열의 길이 중 가장 짧은 값 리턴하기











    }

}
