package Arrays.SubArrays;

public class SumOfAllSubarrays {
    public long subarraySum(int[] A) {
        long ans = 0;

        for (int i = 0; i < A.length; i++) {
            int occurences = (i + 1) * (A.length - i);
            ans = ans + A[i] * occurences;
        }

        return ans;
    }
}
