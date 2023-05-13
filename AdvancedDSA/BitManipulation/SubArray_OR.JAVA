// package AdvancedDSA.BitManipulation;

public class SubArray_OR {
    public static void main(String[] args) {
        
    }

    public int solve(int[] A) {
        int n = A.length;
        long ans=0;
        int mod = Math.pow(10,9)+7;
        
        for(int i=31;i>=0;i--){
            int numberOfElementsWithThisSetBit = 0;
            for(int j=0;j<n;j++) {
                if(((A[j]>>i)&1)==1){
                    ans = ans + ((n-j)*(Math.pow(2,i)));      
                    ans = ans % mod;
                }
            }
            
        }
        return ans%mod;
    }
}