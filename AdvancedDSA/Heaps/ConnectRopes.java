package AdvancedDSA.Heaps;

import java.util.PriorityQueue;

public class ConnectRopes {
    public static void main(String[] args) {

    }

    public int solve(int[] A) {
        int n = A.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++)
            queue.add(A[i]);

        int totalSum = 0;
        while (queue.size() != 1) {
            int n1 = queue.poll();
            int n2 = queue.poll();
            int sum = n1 + n2;
            totalSum += sum;
            queue.add(sum);
        }
        return totalSum;
    }
}
