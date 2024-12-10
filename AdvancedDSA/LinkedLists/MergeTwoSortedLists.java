package AdvancedDSA.LinkedLists;

public class MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode a = A;
        ListNode b = B;
        ListNode ans = new ListNode(0);
        ListNode curr = ans;

        while (a != null && b != null) {
            if (a.val < b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }   
            curr = curr.next;
        }

        if (a != null) {
            curr.next = a;
        }

        if (b != null) {
            curr.next = b;
        }

        return ans.next;
    }
}
