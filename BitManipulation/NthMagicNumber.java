package BitManipulation;

public class NthMagicNumber {
    public int solve(int A) {
        int ans = 0;
        int i = 1;
        while (A > 0) {

            if ((A & 1) == 1)
                ans = ans + (int) Math.pow(5, i);
            i++;
            A >>= 1;
        }
        return ans;
    }
}
