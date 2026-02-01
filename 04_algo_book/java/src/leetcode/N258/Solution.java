package leetcode.N258;

// 258. Add Digits
class Solution {
    public int addDigits(int num) {

        String strNum = String.valueOf(num);

        if (strNum.length() == 1) return Integer.parseInt(strNum);

        while (strNum.length() > 1) {
            int nextValue = 0;

            for (int i = 0; i < strNum.length(); i++) {
                nextValue += Integer.parseInt(strNum.substring(i, i+1));
            }

            strNum = String.valueOf(nextValue);
        }

        return Integer.parseInt(strNum);

    }
}