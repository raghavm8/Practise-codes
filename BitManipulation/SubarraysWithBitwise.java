package BitManipulation;

public class SubarraysWithBitwise {
    public long solve(int A, int[] B) {
        long n = B.length;
        long total = (n * (n + 1)) / 2;
        long count = 0;
        long zeroes = 0;

        for (int i = 0; i < n; i++) {
            if (B[i] == 0) {
                zeroes++;
            } else {
                long c = (zeroes * (zeroes + 1)) / 2;
                count += c;
                zeroes = 0;
            }
        }

        long c = (zeroes * (zeroes + 1)) / 2;
        count += c;

        return total - count;
    }
}

    // long countZeros = 0;
    // long zeroSubarrays = 0;

    // for (int i = 0; i < A; i++) {
    // if (B[i] == 0) {
    // countZeros++;
    // } else {
    // long subarrayCount = (countZeros * (countZeros + 1)) / 2;
    // zeroSubarrays += subarrayCount;
    // countZeros = 0;
    // }
    // }

    // long subarrayCount = (countZeros * (countZeros + 1)) / 2;
    // zeroSubarrays += subarrayCount;

    // return (A * (A + 1)) / 2 - zeroSubarrays;