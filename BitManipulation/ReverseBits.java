package BitManipulation;

public class ReverseBits {
    public long reverse(long a) {
        long ans = 0;

        // n = n|(1<<i);
        // n - n^(i<<i);
        int n = 0;
        int i = 0;
        while (a > 0) {
            if ((a & 1) == 1) {
                n = n ^ (i << (31 - i));
                
            }
        }
        return ans;
    }
}
