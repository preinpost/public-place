package leetcode.N844;

/*
    Input: s = "ab#c", t = "ad#c"
    Output: true
    Explanation: Both s and t become "ac".
 */

/*
    1. StringBuffer 사용, #을 만나면 buffer의 마지막 값 delete


    EdgeCase:
        s = "#" , t = "#"


 */



public class Solution {

    public boolean backspaceCompare(String s, String t) {
        String processed_s = stringChecker(s);
        String processed_t = stringChecker(t);

        if (processed_s.equals(processed_t)) return true;
        return false;
    }

    public String stringChecker(String str) {
//        if (str.equals("#")) return "";

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (sb.length() > 0)
                    sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "ab#c";
//        String t = "ad#c";

        String s = "a##c";
        String t = "#a#c";


//        String s = "#";
//        String t = "#";


//        String s = "ab##";
//        String t = "c#d#";

//        String s = "a#c";
//        String t = "b";


        Solution sol = new Solution();
        boolean b = sol.backspaceCompare(s, t);
        System.out.println(b);
    }

}
