package Maths;

public class DivisibilityBy8 {
    public int solve(String A) {
        int i = 0, iter = 0;
        long ans = 0;
        long power = 0;
        int n = A.length();
        while (i < (n < 3 ? n : 3)) {
            char c = A.charAt(n - iter - 1);
            int num = Character.getNumericValue(c);
            long remainder = num % 8;
            ans = (long) (ans + (int) remainder * Math.pow(10, power));
            i++;
            power++;
            iter++;
        }
        return ans % 8 == 0 ? 1 : 0;
    }
}
