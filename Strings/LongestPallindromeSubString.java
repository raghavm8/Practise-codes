package Strings;

public class LongestPallindromeSubString {
    public static void main(String[] args) {
        
    }

    public String longestPalindrome(String A) {
        int n = A.length();
        String ans = "";

        for (int i = 0; i < n; i++) {
            String oddString = getSubstring(A, i, i);
            ans = ans.length() < oddString.length() ? oddString : ans;
        }

        for (int i = 0; i < n-1; i++) {
            String evenString = getSubstring(A, i, i + 1);
            ans = ans.length() < evenString.length() ? evenString : ans;
        }
        return ans;
    }

    public static String getSubstring(String A, int left, int right) {
        while (left >= 0 && right <= A.length() - 1 && A.charAt(left) == A.charAt(right)) {
            left--;
            right++;
        }
        return A.substring(left + 1, right);
    }
}
