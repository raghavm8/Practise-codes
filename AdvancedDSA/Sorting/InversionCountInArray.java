package AdvancedDSA.Sorting;

public class InversionCountInArray {
    int count = 0;
    static int mod1 = 1000000007;

    public int solve(int[] A) {
        int n = A.length;
        // int ans = 0;
        sort(A, 0, n - 1);
        return count;
    }

    public void sort(int[] a, int left, int right) {
        if (left >= right)
            return;
        // int mid = left + (right - left) / 2;
        int mid = (left + right) / 2;
        sort(a, left, mid);
        sort(a, mid + 1, right);
        merge(a, left, right, mid);
        // System.out.println(i1 + " " + i2 + " " + m);
        // return (i1 + i2 + m) % mod;
    }

    public void merge(int[] A, int s, int e, int mid) {
        int n1 = mid - s + 1; // number of elements in array1
        int n2 = e - mid;// number of elements in array2
        int A1[] = new int[n1];
        int A2[] = new int[n2];
        int index = 0;

        // filling A1 and A2
        for (int i = s; i <= mid; i++)
            A1[index++] = A[i];

        index = 0;
        for (int i = mid + 1; i <= e; i++)
            A2[index++] = A[i];

        int i = 0, j = 0; // i and j referncing A1 and A2 array respectively
        index = s; // important

        while (i < n1 && j < n2) {
            if (A1[i] <= A2[j]) // equals to condition for equal elements
                A[index++] = A1[i++];
            else {
                count = (count + (A1.length - i)) % mod1; // here fulfilling problem statement condition
                A[index++] = A2[j++];
            }
        }
        // if some elements still remaining after traversal
        if (i < n1) {
            while (i < n1) {
                A[index++] = A1[i++];
            }
        } else {
            while (j < n2) {
                A[index++] = A2[j++];
            }
        }
    }

    // private static void merge(int[] a, int left, int right, int mid, int mod) {
    // int n = mid - left + 1;
    // int m = right - mid;
    // int[] l = new int[n];
    // int[] r = new int[m];
    // // int count = 0;

    // for (int i = left; i < mid; i++) {
    // l[i - left] = a[i];
    // }

    // for (int i = mid + 1; i < right; i++) {
    // r[i - (mid + 1)] = a[i];
    // }

    // int i = 0, j = 0, k = 0;
    // k=left;
    // while (i < n && j < m) {
    // if (l[i] <= r[j]) {
    // a[k++] = l[i++];
    // } else {
    // count = ((count % mod) + (n - i) % mod) % mod;
    // a[k++] = r[j++];
    // }
    // }

    // while (i < n) {
    // a[k++] = l[i++];
    // }

    // while (j < m) {
    // a[k++] = r[j++];
    // }
    // // return count;
    // }
}
