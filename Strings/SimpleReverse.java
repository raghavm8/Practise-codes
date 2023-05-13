package Strings;

public class SimpleReverse {
    public static void main(String[] args) {

    }

    public String solve(String a) {
        int n = a.length();
        char[] c = a.toCharArray();
        int i = 0, j = n - 1;

        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        String ans = String.copyValueOf(c);
        return ans;

    }
}