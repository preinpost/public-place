package lecture.L05;

import java.util.ArrayList;
import java.util.Scanner;

public class L0502 {

    public ArrayList<Character> solution(String str) {
        ArrayList<Character> stk = new ArrayList<>();

        for (char c : str.toCharArray()) {
            stk.add(c);

            if (c == ')') {

                for (int i = stk.size()-1; i >= 0; i--) {
                    if(stk.get(i) == '(') {

                        for (int j = stk.size()-1; j >= i; j--) {
                            stk.remove(j);
                        }
                        break;
                    }
                }

            }
        }

        return stk;

    }

    public static void main(String[] args) {

        L0502 T = new L0502();

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        for (Character c : T.solution(str)) {
            System.out.print(c);
        }

    }
}
