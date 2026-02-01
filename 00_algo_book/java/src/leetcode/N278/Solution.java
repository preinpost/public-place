package leetcode.N278;

// 278. First Bad Version
//public class Solution extends VersionControl {
//    public int firstBadVersion(int n) {
//
//        int p1 = 0;
//        int p2 = n;
//
//        while (p1 < p2) {
//            int mid = p1 + (p2 - p1) / 2;
//
//            if (isBadVersion(mid) == true) {
//                p2 = mid;
//            } else {
//                p1 = mid + 1;
//            }
//        }
//        return p2;
//    }
//}