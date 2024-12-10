package Arrays.PrefixSum;

public class ProductArrayPuzzle {
    public static void main(String[] args) {

    }

    public int[] solve(int[] a) {
        int[] prefixArray = new int[a.length];

        prefixArray[0] = a[0];
        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] * a[i];
        }

        for (int i = 0; i < prefixArray.length; i++) {
            a[i] = prefixArray[prefixArray.length-1]/a[i];
        }
        return a;
    }
}
