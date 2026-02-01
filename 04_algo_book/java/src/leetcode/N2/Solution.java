package leetcode.N2;

// 2. Add Two Numbers
class Solution {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(0);
        ListNode answer = curr;

        int up = 0;

        while (true) {
            if (l1 != null && l2 != null) {
                int tmp = up + l1.val + l2.val;
                up = tmp / 10;
                curr.next = new ListNode(tmp % 10);

                curr = curr.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null && l2 == null) {
                break;
            } else if (l1 == null) {
                int tmp = up + l2.val;
                up = tmp / 10;
                curr.next = new ListNode(tmp % 10);
                curr = curr.next;
                l2 = l2.next;
            } else if (l2 == null) {
                int tmp = up + l1.val;
                up = tmp / 10;
                curr.next = new ListNode(tmp % 10);
                curr = curr.next;
                l1 = l1.next;
            }
        }

        if (up != 0) {
            curr.next = new ListNode(up);
        }

        return answer.next;
    }
}