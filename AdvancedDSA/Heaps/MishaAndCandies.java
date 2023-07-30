package AdvancedDSA.Heaps;

import java.util.PriorityQueue;

public class MishaAndCandies {
    public static void main(String[] args) {
        // int[] a = new int[] { 579, 542, 376, 407, 323, 508, 351, 100 };
        // int[] a = new int[] { 56, 700, 552, 247, 601, 453, 179, 661 };
        int[] a = new int[] { 324, 458, 481, 167, 939, 444, 388, 612, 943, 890, 953, 403, 653, 136, 168, 163, 186,
                471 };

        int b = 231;
        System.out.println(solve(a, b));
    }

    public static int solve(int[] A, int B) {
        int ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] > B)
                continue;
            queue.add(A[i]);
        }
        while (!queue.isEmpty()) {
            int box = queue.poll();
            if (box > B)
                break;
            int eaten = (int) Math.floor(box / 2);
            ans += eaten;
            int leftOver = box - eaten;
            if (queue.isEmpty())
                continue;
            int min = queue.peek();
            // if (min + leftOver <= B) {
            queue.poll();
            queue.add(min + leftOver);
            // }
        }
        return ans;
    }
}
