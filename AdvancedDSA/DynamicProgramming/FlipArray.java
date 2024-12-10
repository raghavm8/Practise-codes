package AdvancedDSA.DynamicProgramming;

public class FlipArray {
    public static void main(String[] args) {
        int[] arr = new int[] { 5, 4, 6, 8, 7, 2, 3 };
        System.out.println(new FlipArray().solve(arr));
    }

    public int solve(final int[] A) {
        int n = A.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += A[i];
        }
        int capacity = total / 2;
        SumNumberPair[][] pairs = new SumNumberPair[n + 1][capacity + 1];
        int ans = getMinFlips(pairs, A, capacity, n);
        return ans;
    }

    private int getMinFlips(SumNumberPair[][] pairs, int[] a, int capacity, int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    pairs[i][j] = new SumNumberPair(0, 0);
                } else {
                    if (a[i - 1] > j) {
                        pairs[i][j] = pairs[i - 1][j];
                    } else {
                        SumNumberPair reject = pairs[i - 1][j];
                        int sum = a[i - 1] + pairs[i - 1][j - a[i - 1]].sum;
                        int items = 1 + pairs[i - 1][j - a[i - 1]].items;
                        SumNumberPair accept = new SumNumberPair(sum, items);
                        pairs[i][j] = getBestPair(accept, reject);
                    }
                }
            }
        }
        return pairs[n][capacity].items;
    }

    private SumNumberPair getBestPair(SumNumberPair accept, SumNumberPair reject) {
        if (accept.sum > reject.sum)
            return accept;
        else if (accept.sum < reject.sum)
            return reject;
        else
            return accept.items < reject.items ? accept : reject;
    }
}

class SumNumberPair {   
    public int sum;
    public int items;

    public SumNumberPair(int s, int i) {
        sum = s;
        items = i;
    }
}
