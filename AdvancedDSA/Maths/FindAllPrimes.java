package AdvancedDSA.Maths;

import java.util.ArrayList;

public class FindAllPrimes {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(int A) {
        boolean[] isPrime = new boolean[A+1];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<A+1;i++){
            isPrime[i] = true;
        }

        for(int i=2;i*i<=A;i++){
            if(isPrime[i]==true){
                for(int j=i*i;j<=A;j=j+i){
                        isPrime[j]=false;
                }
            }
        }

        for(int i=2;i<=A;i++){
            if(isPrime[i]==true){
                ans.add(i);
            }
        }
        return ans;
    }
}
