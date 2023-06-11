package AdvancedDSA.Maths;

public class TitleToNumber {
    public static void main(String[] args) {
        System.out.print(titleToNumber("AZ"));
    }

    public static int titleToNumber(String A) {
        int ans = 0;
        int n = A.length();
        if (n == 1)
            return (int) (A.charAt(0) - 'A') + 1;

        for (int i = 0; i < n; i++) {
            char currentChar = A.charAt(n - i - 1);
            // int no = 26 * (i);
            int digVal = (int)Math.pow(26,i);
            int charNum = (int) (currentChar - 'A') + 1;
            ans += charNum * digVal;

        }
        return ans;
    }

}