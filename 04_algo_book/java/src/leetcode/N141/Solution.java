//package leetcode.N141;
//
//// 141. Linked List Cycle
//public class Solution {
//    public boolean hasCycle(ListNode head) {
//
//        if (head == null) return false;
//
//        Set<ListNode> set = new HashSet<>();
//        ListNode currHead = head;
//
//        while (true) {
//
//            if (currHead.next == null) {
//                return false;
//            }
//
//            if (set.contains(currHead)) {
//                return true;
//            }
//
//            set.add(currHead);
//            currHead = currHead.next;
//        }
//    }
//
//    public boolean hasCycle2(ListNode head) {
//
//        ListNode fast = head;
//        ListNode slow = head;
//
//        while (true) {
//
//            if (fast == null || fast.next == null) {
//                return false;
//            }
//
//            fast = fast.next.next;
//            slow = slow.next;
//
//            if (fast == slow) return true;
//        }
//    }
//}