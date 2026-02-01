package leetcode.N24;

public class Main {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {

            ListNode newRoot = new ListNode();
            ListNode lastNode = null;

            if (head == null) return null;
            if (head.next == null) return head;

            while (head != null) {
                ListNode first = new ListNode(head.val);

                if (head.next == null) {
                    lastNode.next = first;
                    return newRoot;
                }

                ListNode second = new ListNode(head.next.val);

                head = head.next.next;


                second.next = first;


                if (lastNode == null) {
                    newRoot = second;
                }
                else {
                    lastNode.next = second;
                }

                lastNode = first;

                if (head == null) return newRoot;
            }

            return newRoot;
        }
    }

    public static void main(String[] args) {

        Main main = new Main();

//        ListNode headNode = new ListNode();
        ListNode headNode = new ListNode(1);
        headNode.next = new ListNode(2);
        headNode.next.next = new ListNode(3);
//        headNode.next.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode head = solution.swapPairs(headNode);

        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);
//        System.out.println(head.next.next.next.val);



    }


}
