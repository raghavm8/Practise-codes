package BitManipulation;

public class Unset_X_BitsFromRight {
    public long solve(long A, int B) {
        for (int i = 0; i < B; i++) {
            if (((A >> i) & 1) == 1) {
                A = A ^ (1 << i);
            }
        }
        return A;
    }
}
