package Strings;

public class StringOperations {
    public static void main(String[] args) {

    }

    public String solve(String A) {
        int n = A.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char currChar = A.charAt(i);
            if (currChar >= 'A' && currChar <= 'Z')
                continue;
            if (currChar == 'a' || currChar == 'u' || currChar == 'o' || currChar == 'i' || currChar == 'e') {
                sb.append("#");
                continue;
            }
            sb.append(currChar);
        }
        String ans = sb.toString();
        return ans + ans;
    }
}
