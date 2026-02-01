package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B2577 {

    public static void main(String[] args) throws IOException {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(i, 0);
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        int c = Integer.parseInt(bf.readLine());

        long multiple = ((long) a * b * c);
        String s = String.valueOf(multiple);

        for (int i = 0; i < s.length(); i++) {

            map.put(Character.getNumericValue(s.charAt(i)), map.get(Character.getNumericValue(s.charAt(i)))+1);

        }

        for (int integer : map.keySet()) {
            System.out.println(map.get(integer));
        }
    }
}
