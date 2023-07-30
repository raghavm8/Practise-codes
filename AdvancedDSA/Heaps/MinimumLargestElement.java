package AdvancedDSA.Heaps;

import java.util.PriorityQueue;

public class MinimumLargestElement {
    public static void main(String[] args) {
        
    }

    public int solve(int[] A, int B) {
        int n = A.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            queue.add(A[i]);
        }

        // while()

        return ans;
    }
}
