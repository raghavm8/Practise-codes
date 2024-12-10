package AdvancedDSA.LinkedLists;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode A) {
        ListNode current = A;
        while (current != null) {
            if (current.next != null) {
                if (current.val == current.next.val) {
                    while (current.val == current.next.val) {
                        current.next = current.next.next;
                        if (current.next == null)
                            break;
                    }
                }
            }
            current = current.next;
        }
        return A;
    }
}
