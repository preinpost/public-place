package leetcode.N1704;

// 1704. Determine if String Halves Are Alike
public class Solution {
    public boolean halvesAreAlike(String s) {

        int l = s.length();

        int f = 0, b = 0;
        for (int i = 0; i < l/2; i++) {
            char c = s.charAt(i);

            if (isVowel(s.charAt(i))) {
                f += 1;
            }

            if (isVowel(s.charAt(l-i-1))) {
                b += 1;
            }
        }

        if (f == b) return true;
        return false;
    }

    boolean isVowel(char c) {
        switch(c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }
}
