package Strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] A) {
        int n = A.length;
        String longestString = A[0];
        for (int i = 0; i < n; i++) {
            String currentString = A[i];
            longestString = getCommonString(longestString, currentString);
            if (longestString.length() == 0)
                break;
        }
        return longestString;
    }

    public String getCommonString(String longestString, String currentString) {
        int j = 0, k = 0;
        boolean isUpdated = false;
        int longestLength = longestString.length();
        int currentStringLength = currentString.length();
        while (j < longestLength && k < currentStringLength) {
            int currChar = currentString.charAt(k);
            if (currChar != longestString.charAt(j)) {
                longestString = longestString.substring(0, j);
                isUpdated = true;
                break;
            }
            j++;
            k++;
        }
        return isUpdated == false ? currentStringLength < longestLength ? currentString : longestString : longestString;
    }

    // public String longestCommonPrefix(String[] A) {
    // int n = A.length;
    // String longestString = A[0];
    // int longestLength = A[0].length();
    // for (int i = 0; i < n; i++) {
    // int currentStringLength = A[i].length();
    // // longestString = currentStringLength > longestLength ? longestString :
    // A[i];

    // int j = 0,k=0;
    // while (j < longestLength && k < currentStringLength) {
    // int currChar = A[i].charAt(j);
    // if (currChar != longestString.charAt(j)) {
    // longestString = longestString.substring(0, j);
    // longestLength = longestString.length();
    // break;
    // }
    // j++;
    // }

    // // for (int j = 0; j < A[i].length(); j++) {
    // // if ( A[i].charAt(j) != longestString.charAt(j)) {
    // // longestString = longestString.substring(0, j);
    // // longestLength = longestString.length();
    // // break;
    // // }
    // // }
    // }

    // return longestString;
    // }
}
