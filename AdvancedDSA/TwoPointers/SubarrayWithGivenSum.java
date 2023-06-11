package AdvancedDSA.TwoPointers;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] a = new int[] { 1, 100000 };
        int[] A = solve(a, 100000);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

    public static int[] solve(int[] A, int B) {
        int n = A.length;
        int left = 0, right = 0, sum = 0;

        while (right < n) {
            if (sum < B) {
                sum += A[right++];
            }
            if (sum > B) {
                sum -= A[left];
                left++;
            }
            if (sum == B) {
                int k = 0;
                int[] ans = new int[right - left];
                for (int i = left; i < right; i++) {
                    ans[k++] = A[i];
                }
                return ans;
            }
        }
        return new int[] { -1 };
    }
}