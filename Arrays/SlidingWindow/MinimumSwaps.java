package Arrays.SlidingWindow;

public class MinimumSwaps {
    public int solve(int[] A, int B) {
        int ans = 0;

        int countOfLesser = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < B)
                countOfLesser++;
        }

        int lesser = 0;
        for (int i = 0; i < countOfLesser; i++) {
            if (A[i] < B)
                lesser++;
        }

        ans = lesser;
        for (int i = countOfLesser; i < A.length; i++) {
            if (A[i] < B)
                lesser++;
            if (A[i - countOfLesser] < B)
                lesser--;

            ans = Math.max(ans, lesser);
        }

        return countOfLesser - ans;
    }
}
