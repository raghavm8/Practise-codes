package Arrays.CarryForward;

public class ClosestMinMax {
    public int solve(int[] a) {
        int n = a.length;
        int ans = n;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int maxIndex = -1;
        int minIndex = -1;

        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, a[i]);
            minValue = Math.min(minValue, a[i]);
        }

        for (int i = 0; i < n; i++) {
            if (a[i] == maxValue) {
                maxIndex = i;
                if(minIndex != -1)
                    ans = Math.min(ans, i - minIndex + 1);
            }

            if (a[i] == minValue) {
                minIndex = i;
                if(maxIndex != -1)
                    ans = Math.min(ans, i - maxIndex + 1);
            }
        }
        return ans;
    }
}
