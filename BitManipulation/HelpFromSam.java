package BitManipulation;

public class HelpFromSam {
    public int solve(int A) {
        int ans = 0;
        while (A > 0) {
            if ((A & 1) == 1) {
                A--;
                ans++;
            } else {
                A >>= 1;
            }
        }
        return ans;
    }
}
