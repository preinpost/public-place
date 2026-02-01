package sk2022B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A {

    public String[] solution(String[] goods) {
        String[] answer = new String[goods.length];

        for (int i = 0; i < goods.length; i++) {

            int start = 0;
            int checkLength = 1;
            List<String> candid = new ArrayList<>();

            while (checkLength <= goods[i].length()) {
                if (start + checkLength > goods[i].length()) {

                    if (!candid.isEmpty()) {
                        Collections.sort(candid);

                        StringBuilder sb = new StringBuilder();

                        for (String c : candid) {
                            sb.append(c);
                            sb.append(" ");
                        }

                        answer[i] = sb.toString().substring(0, sb.length()-1);
                        break;
                    }

                    start = 0;
                    checkLength++;
                    continue;
                }

                String extracted = goods[i].substring(start, start+checkLength);
                boolean extractedFlag = false;

                for (int j = 0; j < goods.length; j++) {
                    if (i == j) continue;

                    boolean contains = goods[j].contains(extracted);
                    if (contains == true) {
                        extractedFlag = true;
                        break;
                    }
                }

                if (extractedFlag == false) {
                    if (!candid.contains(extracted))
                        candid.add(extracted);
                }

                start++;
            }

            if (candid.isEmpty()) {
                answer[i] = "None";
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        A a = new A();

//        String[] goods = new String[] {"pencil"};
//        String[] goods = new String[] {"pencil","cilicon","contrabase","picturelist"};
//        String[] goods = new String[] {"aaa","bbb","ccc","ddddd", "aaaaaa"};
//        String[] goods = new String[] {"aa", "zabz","bb","cc", "dd"};
        String[] goods = new String[] {"abcdeabcd","cdabe","abce","bcdeab"};
//        String[] goods = new String[] {"bcdeab", "abcdeabcd","cdabe","abce"};

        String[] solution = a.solution(goods);
        for (String s : solution) {
            System.out.println("s = " + s);
        }

    }
}
