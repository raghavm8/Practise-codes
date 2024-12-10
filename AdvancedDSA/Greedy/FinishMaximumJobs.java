package AdvancedDSA.Greedy;

import java.util.ArrayList;
import java.util.Comparator;

public class FinishMaximumJobs {
    public int solve(int[] A, int[] B) {
        int n = A.length;
        int ans = 0;
        ArrayList<StartEndPair> pairs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StartEndPair pair = new StartEndPair(A[i], B[i]);
            pairs.add(pair);
        }

        int end = pairs.get(0).endTime;
        for (int i = 1; i < n; i++) {
            StartEndPair pair = pairs.get(i);
            if (pair.startTime >= end) {
                ans++;
                end = pair.endTime;
            }
        }

        return ans;
    }
}

class StartEndPair {
    int startTime;
    int endTime;

    StartEndPair(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class EndTimeSorting implements Comparator<StartEndPair> {

    public int compare(StartEndPair p1, StartEndPair p2) {
        if (p1.endTime < p2.endTime) {
            return -1;
        } else {
            return 1;
        }
    }
}