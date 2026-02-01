package basic;

import java.util.ArrayList;
import java.util.List;

public class CombinationV3 {

    public static void main(String[] args) {
        String str = "ABCDEF";

        String[] array = str.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .toArray(String[]::new);

        List<String> strSet = new ArrayList<>();
        List<List<String>> candid = new ArrayList<>();
        candid.add(new ArrayList<>());

        combi(3, 0, 0, strSet, candid, array);

    }

    static private void combi(int target, int curLength, int startIdx, List<String> save, List<List<String>> candid, String[] array) {
        if (target == curLength) {
            System.out.println("save = " + save);
            candid.add(save);
        }

        for (int i = startIdx; i < array.length; i++) {
            String now = array[i];
            save.add(now);
            combi(target, curLength + 1, i + 1, save, candid, array);
            save.remove(now);
        }
    }
}
