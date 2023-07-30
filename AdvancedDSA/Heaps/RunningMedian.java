package AdvancedDSA.Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
    public static void main(String[] args) {

    }

    public int[] solve(int[] A) {
        int n = A.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] ans = new int[n];

        maxHeap.add(A[0]);
        for (int index = 1; index < A.length; index++) {
            if (A[index] <= maxHeap.peek()) {
                maxHeap.add(A[index]);
                if (maxHeap.size() - minHeap.size() > 1) {
                    minHeap.add(maxHeap.poll());
                }
            } else {
                minHeap.add(A[index]);
                if (maxHeap.size() - minHeap.size() < 0) {
                    maxHeap.add(minHeap.poll());
                }
            }
            ans[index] = maxHeap.peek();
        }
        return ans;
    }
}


