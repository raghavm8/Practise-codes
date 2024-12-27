package BitManipulation;

public class AnyBaseToDecimal {
    public int solve(int A, int B) {
        int power = 0;
        int ans = 0;
        while (A != 0) {
            int digit = A % 10;
            ans += digit * Math.pow(B, power);
            power++;
            A /= 10;
        }
        return ans;
    }
}
