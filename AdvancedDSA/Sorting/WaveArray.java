package AdvancedDSA.Sorting;

import java.util.Arrays;

public class WaveArray {
    public static void main(String[] args) {

    }

    public int[] wave(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Arrays.sort(A);
        for (int i = 0; i < n - 1; i++) {
            int temp = A[i];
            A[i] = A[i + 1];
            A[i + 1] = temp;
        }
        return ans;
    }

}