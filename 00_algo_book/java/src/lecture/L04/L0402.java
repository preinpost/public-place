package lecture.L04;

import java.util.HashMap;
import java.util.Scanner;

public class L0402 {

    public String solution(String str1, String str2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        for (char x : arr1) {
            map1.put(x, map1.getOrDefault(x, 0)+1);
        }

        for (char x : arr2) {
            map2.put(x, map2.getOrDefault(x, 0)+1);
        }

        for (Character key : map1.keySet()) {
            if (map2.containsKey(key)) {
                if (map2.get(key) != map1.get(key)) return "NO";
            } else {
                return "NO";
            }
        }

        return "YES";


    }

    public static void main(String[] args) {

        L0402 T = new L0402();

        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        System.out.println(T.solution(str1, str2));
    }
}
