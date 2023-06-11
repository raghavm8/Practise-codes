package AdvancedDSA.Sorting;

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {

    }

    public int count = 0;
    public int solve(int[] A) {
        int n = A.length;
        sort(A, 0, n - 1);
        return count;
    }

    public void sort(int[] a, int left, int right) {
        if (left >= right)
            return;

        int pivot = partition(a, left, right);
        count++;
        sort(a, left, pivot - 1);
        sort(a, pivot + 1, right);
    }

    private int partition(int[] a, int left, int right) {
        // int n = a.length;
        int pivot = a[right];
        int index = left - 1;
        for (int i = left; i < right; i++) {
            if (a[i] < pivot) {
                index++;
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }
        return index + 1;
    }
}
