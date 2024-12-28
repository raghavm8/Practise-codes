package BitManipulation;

public class NumberOfSetBits {
    public int numSetBits(int A) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            if (((A >> i) & 1) == 1)
                ans++;
        }
        return ans;
    }
}
