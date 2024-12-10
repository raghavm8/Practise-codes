package AdvancedDSA.LinkedLists;

public class DeleteNode {
    public static void main(String[] args) {

    }

    public ListNode solve(ListNode A, int B) {
        ListNode curr = A;
        int i = 0;

        while (curr != null && i < B) {
            if (i == B) {
                curr.next = curr.next.next;
            }
            i++;
        }
        return A;
    }
}
