package AdvancedDSA.Heaps;

import java.util.PriorityQueue;

public class AthLargestElement {
    public int[] solve(int A, int[] B) {
        int n = B.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < B.length; i++) {
            queue.add(B[i]);

            if (queue.size() < A) {
                B[i] = -1;
                continue;
            }

            if (queue.size() > A) {
                queue.poll();
            }

            B[i] = queue.peek();
        }
        return B;
    }
}