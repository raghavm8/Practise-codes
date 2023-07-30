package AdvancedDSA.Heaps;

import java.util.PriorityQueue;

public class K_PlacesApart {
    public static void main(String[] args) {

    }

    public int[] solve(int[] A, int B) {
        int n = A.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i <= B; i++) {
            queue.add(A[i]);
        }

        int index = 0;
        for (int i = B + 1; i < n; i++) {
            A[index++] = queue.poll();
            queue.add(A[i]);
        }

        while (!queue.isEmpty()) {
            A[index++] = queue.poll();
        }
        
        return A;
    }
}
