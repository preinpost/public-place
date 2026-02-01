package programmers.book.P25;

// P25. H-Index

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int h = citations.length; h >= 1; h--) {
            int count = getCount(h, citations);
            if (count >= h && citations.length - h <= h) return h;
        }
        return 0;
    }

    private int getCount(int h, int[] citations) {
        for (int i = 0; i < citations.length; i++) {
            if (h <= citations[i]) return citations.length - i;
        }
        return -1;
    }
}