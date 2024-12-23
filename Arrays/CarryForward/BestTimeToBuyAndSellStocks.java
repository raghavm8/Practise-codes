package Arrays.CarryForward;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        int[] a = { 1, 4, 5, 2, 4 };
        maxProfit(a);
    }

    public static int maxProfit(final int[] A) {
        int ans = 0;
        int n = A.length;
        if (n < 2)
            return 0;

        // int[] max = new int[n];
        // max[n - 1] = A[n - 1];
        // for (int i = n - 2; i >= 0; i--) {
        // max[i] = Math.max(max[i + 1], A[i]);
        // }

        int maxP = Integer.MIN_VALUE;
        int max = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, A[i + 1]);
            int profit = max - A[i];
            maxP = Math.max(maxP, profit);
        }

        return maxP;
    }
}

// 1, 4, 5, 2, 4
