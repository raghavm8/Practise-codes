package AdvancedDSA.LinkedLists;

public class PalindromeList {
    public static void main(String[] args) {

    }

    public int lPalin(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        ListNode reversedHead = null, prevToSlow = A;
        ListNode mid = null;

        if (A != null && A.next != null) {
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                prevToSlow = slow;
                slow = slow.next;
            }

            if (fast != null) {
                mid = slow;
                slow = slow.next;
            }

            reversedHead = slow;
            prevToSlow.next = null;
            reversedHead = reverse(reversedHead);
            return compareListNode(reversedHead, A);
        }
        return 1;
    }

    private ListNode reverse(ListNode node) {
        ListNode nextt = null;
        ListNode current = node;
        ListNode prev = null;

        while (current != null) {
            nextt = current.next;
            current.next = prev;
            prev = current;
            current = nextt;
        }
        return prev;
    }

    private int compareListNode(ListNode a, ListNode b) {
        ListNode temp1 = a;
        ListNode temp2 = b;

        while (temp1 != null && temp2 != null) {
            if (temp1.val == temp2.val) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else
                return 0;
        }

        if (temp1 == null && temp2 == null)
            return 1;
        return 0;
    }
}
