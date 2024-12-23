package Arrays.SubArrays;

public class GoodSubarrays {
    public int solve(int[] A, int B) {
        int n = A.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int count = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                count++;
                if (count % 2 == 0) {
                    if (sum < B)
                        ans++;
                } else {
                    if (sum > B)
                        ans++;
                }
            }
        }
        return ans;
    }
}
