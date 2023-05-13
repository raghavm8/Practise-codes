package AdvancedDSA.InterviewQuestions;

import java.util.ArrayList;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {
    public static void main(String[] args) {

    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        ArrayList<Interval> ans = new ArrayList<>();
        int i = 0;
        while (i < n && intervals.get(i).end < newInterval.start) {  
            ans.add(intervals.get(i));
            i++;
        }

        while (i < n && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        ans.add(newInterval);
        while (i < n) {
            ans.add(intervals.get(i));
            i++;
        }
        return ans;
    }
}
