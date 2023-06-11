package AdvancedDSA.Sorting;

public class CountSort {
    public static void main(String[] args) {

    }

    public int[] solve(int[] A) {
        int n = A.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(A[i], max);
        }

        int[] freq = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            freq[A[i]]++;
        }
        int k=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < freq.length; j++) {
                A[k++] = i;
            }
        }
        return A;
    }

}
