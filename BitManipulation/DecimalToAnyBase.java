package BitManipulation;

public class DecimalToAnyBase {
    public int DecimalToAnyBase1(int A, int B) {
        int ans = 0;
        int power = 0;
        while (A != 0) {
            int remainder = A % B;
            A = A / B;
            ans = (int) (ans + remainder * Math.pow(10, power));
            power++;
        }
        return ans;
    }
}
