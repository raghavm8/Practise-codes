package Arrays.CarryForward;

public class SpecialSubsequences_AG {
    public long solve(String A) {
        long ans = 0;
        int n = A.length();

        // ABCGAG
        int count = 0;
        for (int i = n - 1; i > 0; i++) {
            if (A.charAt(i) == 'G') {
                count += 1;
            }
            if (A.charAt(i) == 'A') {
                ans += count;
            }
        }
        return ans;
    }
}
