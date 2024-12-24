package Arrays.Matrices;

public class MajorDiagonal {
    public int solve(final int[][] A) {
        int ans = 0;
        int rows = A.length;
        for (int i = 0; i < rows; i++) 
            ans+=A[i][i];
        
        return ans;
    }
}
