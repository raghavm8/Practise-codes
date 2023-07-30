package AdvancedDSA.Heaps;

import java.util.PriorityQueue;

public class MaximumArraySumAfter_B_Negations {
    public static void main(String[] args) {

    }

    public int solve(int[] A, int B) {
        int n = A.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int ans = 0;

        for (int i = 0; i < n; i++)
            queue.add(A[i]);

        int i = 0;
        while (i < B) {
            int element = queue.poll();
            element *= -1;
            queue.add(element);
            i++;
        }

        while(!queue.isEmpty()){
            ans += queue.poll();
        }    
        
        return ans;
    }
}
