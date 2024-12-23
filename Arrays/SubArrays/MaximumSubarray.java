package Arrays.SubArrays;

public class MaximumSubarray {
    public int maxSubarray(int n, int b, int[] a) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum > b)
                    break;
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
