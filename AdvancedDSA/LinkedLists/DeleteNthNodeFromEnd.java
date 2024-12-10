package AdvancedDSA.LinkedLists;

public class DeleteNthNodeFromEnd {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode A, int B) {
        if (A.next == null)
            return null;
        ListNode current = A;
        int length = getLength(A);
        int index = length - B;
        int i = 0;

        if (length == 1)
            return null;

        if (index <= 0)
            return A.next;

        while (current != null && i < index) {
            current = current.next;
            i++;
        }
        current.next = current.next.next;
        return A;
    }

    private int getLength(ListNode a) {
        ListNode curr = a;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }
}
