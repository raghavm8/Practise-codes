package AdvancedDSA.LinkedLists;

public class SortList {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode mid = getMid(A);
        ListNode temp1 = A;
        ListNode temp2 = mid.next;
        mid.next = null;

        temp1 = sortList(temp1);
        temp2 = sortList(temp2);

        return mergeLists(temp1, temp2);
    }

    private ListNode mergeLists(ListNode temp1, ListNode temp2) {
        if (temp1 == null)
            return temp2;
        if (temp2 == null)
            return temp1;

        ListNode head;
        if (temp1.val <= temp2.val) {
            head = temp1;
            temp1 = temp1.next;
        } else {
            head = temp2;
            temp2 = temp2.next;
        }

        ListNode temp = head;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        if (temp1 == null) {
            temp.next = temp2;
        }
        if (temp2 == null) {
            temp.next = temp1;
        }

        return head;
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
