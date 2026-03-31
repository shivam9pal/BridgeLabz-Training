package week03.gcrcodebase.leetcode;

class ReverseList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.print("Original: ");
        print(head);

        head = reverseList(head);

        System.out.print("Reversed: ");
        print(head);
    }
}

