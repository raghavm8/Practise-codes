package BinarySearch;

public class PainterPartition {
    public static void main(String[] args) {
        int[] c = new int[] { 884, 228, 442, 889 };
        int a = 4;
        int b = 10;

        System.out.println(new PainterPartition().paint(a, b, c));
    }

    public int paint(int A, int B, int[] C) {
        int n = C.length;
        int max = C[0];
        long total = C[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(C[i], max);
            total += C[i];
        }

        long start = max * B;
        long end = total * B;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            int count = minPainters(C, B, mid);
            int count1 = minPainters(C, B, mid - 1);

            if (count <= A && count1 > A) {
                return (int) (mid % 10000003);
            }
            if (count <= A)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return (int) (start % 10000003);
    }

    private int minPainters(int[] a, int units, long totalTime) {
        int n = a.length;
        long total = totalTime;
        int count = 1;
        for (int i = 0; i < n; i++) {
            long timeTaken = a[i] * units;
            // int timeLeft = totalTime - timeTaken;

            if (timeTaken > total)
                return -1;
            if (timeTaken <= totalTime) {
                totalTime = totalTime - timeTaken;
            } else {
                count++;
                totalTime = total - timeTaken;
            }
        }
        return count;
    }

    public static int minpainters(int A[], long t, long x) {
        int painter = 1;
        long timeleft = x;
        for (int i = 0; i < A.length; i++) {
            if (A[i] * t > x) {
                return -1;
            }
            if (A[i] * t <= timeleft) {
                timeleft -= A[i] * t;
            } else {
                painter++;
                timeleft = x - A[i] * t;
            }
        }
        return painter;
    }
}
