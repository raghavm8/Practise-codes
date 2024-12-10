package Arrays.PrefixSum;

public class EquilibriumIndex {
    public static void main(String[] args) {

    }

    public int solve(int[] a) {
        int ans = -1;
        int n = a.length;
        long[] prefixArray = new long[n];

        prefixArray[0] = a[0];
        for (int i = 1; i < n; i++)
            prefixArray[i] = prefixArray[i - 1] + a[i];

        if (prefixArray[n - 1] - prefixArray[0] == 0)
            return 0;
            
        for (int i = 1; i < n; i++) {
            long diff = (prefixArray[n - 1] - prefixArray[i]) - prefixArray[i - 1];
            if (diff == 0) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}