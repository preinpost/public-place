package lecture.L04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class L0401 {

    public void solution(int n, String str) {
        char[] arr = str.toCharArray();
        int max = Integer.MIN_VALUE;
        char answer = 0;

        Map<Character, Integer> candidMap = new HashMap<>();

        for (char c : arr) {
            candidMap.put(c, candidMap.getOrDefault(c, 0)+1);
        }

        for (char key : candidMap.keySet()) {
            if (max < candidMap.get(key)) {
                max = candidMap.get(key);
                answer = key;
            }
        }

        System.out.println(answer);


    }

    public static void main(String[] args) {

        L0401 T = new L0401();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();

        T.solution(n, str);
    }
}
