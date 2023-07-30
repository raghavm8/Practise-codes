package AdvancedDSA.Greedy;

public class DistributeCandy {
    public static void main(String[] args) {

    }

    public int candy(int[] A) {
        int ans = 0;
        int n = A.length;
        int[] candy = new int[n];

        for (int i = 0; i < candy.length; i++) {
            candy[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1])
                candy[i] = candy[i - 1] + 1;
        }

        ans = candy[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (A[i + 1] > A[i])
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            ans += candy[i];
        }

        return ans;
    }
}
