package lgcns2022;

import java.util.LinkedList;
import java.util.List;

public class C {

    public static void main(String[] args) {
        C T = new C();

        String reference = "vxrvip";
        String track = "xrviprvipvxrv";

        int solution = T.solution(reference, track);
        System.out.println("solution = " + solution);

    }

    public int solution(String reference, String track) {
        int answer = 0;

        List<String> tokens = createToken(reference);
        int pos = 0;
        String compare = track;

        for (int i = tokens.size() - 1; i >= 0 ; i--) {
            String currentToken = tokens.get(i);

            if (compare.startsWith(currentToken)) {
                pos += currentToken.length();
                if (pos >= compare.length()) {
                    return currentToken.length();
                }
                compare = compare.substring(pos);
            }
        }
        return answer;
    }

    public List<String> createToken(String reference) {
        List<String> tokens = new LinkedList<>();

        for (int i = 1; i <= reference.length(); i++) {
            combination(0, 0, new StringBuilder(), reference, i, tokens);
        }

        return tokens;
    }

    public void combination(int depth, int s, StringBuilder candid, String reference, int length, List<String> tokens) {
        if (depth == length) {
            tokens.add(candid.toString());
            return;
        }

        for (int i = s; i < reference.length(); i++) {
            candid.append(reference.charAt(i));
            combination(depth + 1, i + 1, candid, reference, length, tokens);
            candid.deleteCharAt(depth);
        }
    }

}
