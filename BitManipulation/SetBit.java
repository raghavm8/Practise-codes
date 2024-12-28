package BitManipulation;

public class SetBit {
    public int solve(int A, int B) {
        int n = 0 | (1 << A);
        n = n | (1 << A);
        int ans = 0;
        int i = 0;
        while (n != 0) {
            int remainder = n % 10;
            ans += remainder * Math.pow(2, i);
            i++;
        }
        return ans;
    }
}
