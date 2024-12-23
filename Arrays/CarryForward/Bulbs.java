package Arrays.CarryForward;

public class Bulbs {
    public int bulbs(int[] A) {
        int n = A.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int state = 0;
            if (count % 2 == 0)
                state = A[i];
            else
                state = 1 - A[i];

            if (state == 0)
                count += 1;
        }
        return count;
    }
}
