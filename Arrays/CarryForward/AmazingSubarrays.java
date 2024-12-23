package Arrays.CarryForward;

public class AmazingSubarrays {
    public int solve(String A) {
        int n = A.length();
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (A.charAt(i) == 'A' || A.charAt(i) == 'E' || A.charAt(i) == 'I' || A.charAt(i) == 'O'
                    || A.charAt(i) == 'U' || A.charAt(i) == 'a' || A.charAt(i) == 'e' || A.charAt(i) == 'i'
                    || A.charAt(i) == 'o' || A.charAt(i) == 'u') {
                ans = (ans + (n - i)) % 10003;
            }
        }

        return ans % 10003;
    }
}
