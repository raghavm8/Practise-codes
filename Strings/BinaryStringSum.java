package Strings;

public class BinaryStringSum {
    public static void main(String[] args) {

    }

    public String addBinary(String A, String B) {
        int an = A.length() - 1;
        int bn = B.length() - 1;
        // int n = Math.min(an, bn);
        StringBuilder ans = new StringBuilder();

        while (an >= 0 || bn >= 0) {
            char ac = A.charAt(an);
            char bc = B.charAt(bn);
            
            

            // if(ac=='1' && bc=='1')
            // {

            // }
            // else{

            // }

        }

        // for (int i = n - 1; i >= 0; i--) {
        // char a = A.charAt(i);
        // char b = B.charAt(i);
        // char carry = '\0';
        // if()
        // }

        return ans.toString();
    }
}
