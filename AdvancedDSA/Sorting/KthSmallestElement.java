package AdvancedDSA.Sorting;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = new int[] { 4, 8, 3, 9, 1, 7, 2, 6 };
        printArray(arr);
        int ans = kthsmallest(arr, 1);
        printArray(arr);
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static int kthsmallest(final int[] A, int B) {
        int n = A.length;
        // int ans = 0;
        // int smallestIndex = n-B+1;
        for (int i = n - B; i >= 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (A[j] >= A[maxIndex])
                    maxIndex = j;
            }
            int temp = A[maxIndex];
            A[maxIndex] = A[i];
            A[i] = temp;
            // if (i == smallestIndex) {
            // ans = A[i];
            // }
        }
        return A[B - 1];
        // return ans;
    }
}

// 1 2 3 4 5

// 4 = second largest
// 4 = 4th smallest