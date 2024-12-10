package AdvancedDSA.DynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapSack {
    public static void main(String[] args) {

    }

    public int solve(int A, int[] values, int[] weights) {
        int w = weights.length;
        int v = values.length;

        int[] capacity = new int[A + 1];
        Arrays.fill(capacity, 0);

        for (int i = 1; i <= A; i++) {
            for (int j = 0; j < v; j++) {
                if (i >= weights[j]) {
                    capacity[i] = Math.max(capacity[i], values[j] + capacity[i - weights[j]]);
                }
            }
        }
        return capacity[A];
    }
}
