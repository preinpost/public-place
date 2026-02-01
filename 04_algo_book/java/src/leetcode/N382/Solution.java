package leetcode.N382;

import java.util.ArrayList;
import java.util.List;

// 382. Linked List Random Node
//class Solution {
//
//    List<Integer> list = new ArrayList<>();
//
//    public Solution(ListNode head) {
//        ListNode node = null;
//
//        while ((node = head) != null ) {
//            list.add(head.val);
//            head = head.next;
//        }
//    }
//
//    public int getRandom() {
//        int i = (int) (Math.random() * list.size());
//        return list.get(i);
//    }
//}