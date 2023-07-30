package AdvancedDSA.Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import AdvancedDSA.LinkedLists.ListNode;

public class Merge_K_SortedLists {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        int n = a.size();
        PriorityQueue<ListNode> queue = new PriorityQueue<>(n, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode x, ListNode y) {
                return x.val - y.val;
            }
        });

        for (int i = 0; i < n; i++) {
            queue.add(a.get(i));
        }

        ListNode ans = queue.poll();
        ListNode curr = ans;
        if (ans.next != null)
            queue.add(ans.next);
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null)
                queue.add(curr.next);
        }
        return ans;
    }
}
