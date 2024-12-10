package AdvancedDSA.LinkedLists;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode A) {
        ListNode curr = A;
        ListNode nextt = null;
        ListNode prev = null;

        while (curr != null) {
            nextt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextt;
        }
        return prev;
    }
}
