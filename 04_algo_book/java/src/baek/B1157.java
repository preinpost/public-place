package baek;

import java.util.*;

public class B1157 {

    public char solution(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(Character.toUpperCase(c), map.getOrDefault(Character.toUpperCase(c), 0)+1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

        if (list.size() > 1 && list.get(0).getValue().equals(list.get(1).getValue())) {
            return '?';
        }

        return list.get(0).getKey();
    }

    public static void main(String[] args) {

        B1157 T = new B1157();

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(T.solution(str));
    }
}
