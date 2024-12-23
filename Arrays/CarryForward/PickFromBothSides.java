package Arrays.CarryForward;

public class PickFromBothSides {

    public static void main(String[] args) {
        int[] a = { 5, -2, 3, 1, 3 };
        int b = 3;
        System.out.println(solve(a, b));
    }

    public static int solve(int[] A, int B) {
        int ans = 0;
        int n = A.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = A[0];
        suffix[n - 1] = A[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + A[i];
            suffix[n - i - 1] = suffix[n - i] + A[n - i - 1];
        }

        // print(prefix);
        // print(suffix);
        ans = Math.max(prefix[B - 1], suffix[n - B]);
        // System.out.println(ans);
        for (int i = 1; i < B; i++) {
            int sum = prefix[i - 1] + suffix[n - B + i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int solve1(int[] A, int B) {
        int sum = 0;
        int n = A.length;
        int left = 0, right = n - 1;

        while (B > 0) {
            if (A[left] >= A[right]) {
                sum += A[left];
                left++;
            } else {
                sum += A[right];
                right--;
            }
            B--;
        }

        return sum;
    }
}
